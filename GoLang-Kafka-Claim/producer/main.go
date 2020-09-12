package main

import (
	"bytes"
	"encoding/json"
	"github.com/gorilla/mux"
	"github.com/linkedin/goavro"
	"github.com/Shopify/sarama"
	"net/http"
	"strconv"
	"time"
	"log"

	. "github.com/SunPriest/GoLang-Kafka-Claim/verification"
	. "github.com/SunPriest/GoLang-Kafka-Claim/models"
)

var claim = Claim{}

const (
	PRODUCER_URL string = "localhost:9092"
	KAFKA_TOPIC string = "Claims"
	ERROR_TOPIC string = "Errors"
)

//Responds to a POST request
func CreateClaim(w http.ResponseWriter, r *http.Request) {

	recordSchemaJSON := `{
  		"type" : "record",
  		"name" : "Claim",
  		"doc:": "A basic schema for storing data of claims",
  		"namespace" : "com.avro.kafka.golang",
  		"fields" : [ {
  			"doc"  : "ID number",
  			"type" : "string",
    		"name" : "ClaimID"
  		}, {
  			"doc"  : "Member first name",
  			"type" : "string",
    		"name" : "Memberfirst_name"
  		}, {
  			"doc"  : "Member last name",
  			"type" : "string",
    		"name" : "Memberlast_name"
  		}, {
  			"doc"  : "Claim Source",
  			"type" : "string",
    		"name" : "Source"    		
  		}, {
  			"doc"  : "Claim Event",
  			"type" : "string",
    		"name" : "Event"   		
  		}, {
  			"doc"  : "Claim breed",
  			"type" : "string",
    		"name" : "Breed"    		
  		}, {
  			"doc"  : "Unix epoch time in milliseconds",
  			"type" : "long",
    		"name" : "Timestamp"    		
  		} ]
	}`

	//Recieve JSON claim and encode into the defined Go struct
    _ = json.NewDecoder(r.Body).Decode(&claim)
    //sets timestamp, **I was unsure of how this field was meant to be used**, set here so claim is filled out before verification
    claim.TimeStamp = time.Now().UnixNano()
    json.NewEncoder(w).Encode(claim)

	someRecord, err := goavro.NewRecord(goavro.RecordSchema(recordSchemaJSON))
	if err != nil {
		panic(err)
	}

	//Explicitly Marshall nested JSON objects
	claimIDMarshall, err := json.Marshal(claim.ClaimID)
	if err != nil {
		panic(err)
	}

	//VERIFICATION STEP
	&verification.verify(claim)

	//Encode Go struct of Claim into Avro using the schema defined earlier
	someRecord.Set("ClaimID", string(claimIDMarshall))
	someRecord.Set("Memberfirst_name", claim.MemberfirstName)
	someRecord.Set("Memberlast_name", claim.MemberlastName)
	someRecord.Set("Source", claim.Source)
	someRecord.Set("Event", claim.Event)
	someRecord.Set("Breed", claim.Breed)
	someRecord.Set("Timestamp", claim.TimeStamp)

	//reset claim struct
	claim = Claim{}
	

	//create codec for Kafka data from json schema
	codec, err := goavro.NewCodec(recordSchemaJSON)
	if err != nil {
		panic(err)
	}

	//encode new record into bytes using goavro codec
	bb := new(bytes.Buffer)
	if err = codec.Encode(bb, someRecord); err != nil {
		panic(err)
	}

	actual := bb.Bytes()

	//cast to string to send in sarama producer message
	dataString := string(actual)

	//initialize sarama configuration and connect to kafka
	config := sarama.NewConfig()
	config.Producer.Retry.Max = 5
	config.Producer.RequiredAcks = sarama.WaitForAll
	brokers := []string{PRODUCER_URL}
	producer, err := sarama.NewAsyncProducer(brokers, config)
	if err != nil {
		panic(err)
	}

	//if an error occurs, close the sarama connection
	defer func() {
		if err := producer.Close(); err != nil {
			panic(err)
		}
	}()

	//get unix time for producermessage timestamp
	strTime := strconv.Itoa(int(time.Now().Unix()))

	msg := &sarama.ProducerMessage{
		Topic: KAFKA_TOPIC,
		Key:   sarama.StringEncoder(strTime),
		Value: sarama.StringEncoder(dataString),
	}

	producer.Input() <- msg
}

func main() {

	//configure router to handle http post request with claim data as body
	router := mux.NewRouter()
	router.HandleFunc("/claim", CreateClaim).Methods("POST")
    log.Fatal(http.ListenAndServe(":3000", router))

}