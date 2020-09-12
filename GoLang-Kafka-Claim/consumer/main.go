package main

import (
	"fmt"
	"os"
	"os/signal"
	//"time"
	"strconv"
	"strings"

	"github.com/linkedin/goavro"
	"github.com/Shopify/sarama"
)

//struct of a claim, nested json must be nested struct and must be explicitly marshalled after request body is marshalled
type Claim struct {
	ClaimID struct {
		Oid string `json:"$oid"`
	} `json:"ClaimID"`
	MemberfirstName string      `json:"Memberfirst_name"`
	MemberlastName  string      `json:"Memberlast_name"`
	Source          string      `json:"Source"`
	Event           string      `json:"Event"`
	Breed           string      `json:"Breed"`
	TimeStamp       interface{}	`json:"TimeStamp"`
}

type ClaimID struct {
	Oid string `json:"$oid"`
}

var claim Claim

const (
	PRODUCER_URL string = "localhost:9092"
	KAFKA_TOPIC string = "Claims"
)

func main() {

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

	config := sarama.NewConfig()
	config.Consumer.Return.Errors = true

	// Specify brokers address. This is default one
	brokers := []string{PRODUCER_URL}

	// Create new consumer
	master, err := sarama.NewConsumer(brokers, config)
	if err != nil {
		panic(err)
	}

	defer func() {
		if err := master.Close(); err != nil {
			panic(err)
		}
	}()

	// How to decide partition, is it fixed value...?
	consumer, err := master.ConsumePartition(KAFKA_TOPIC, 0, sarama.OffsetOldest)
	if err != nil {
		panic(err)
	}

	signals := make(chan os.Signal, 1)
	signal.Notify(signals, os.Interrupt)

	// Count how many message processed
	msgCount := 0

	//create codec for Kafka data from json schema
	codec, err := goavro.NewCodec(recordSchemaJSON)
	if err != nil {
		panic(err)
	}

	var temp interface{}
	var claim Claim
	var claimid ClaimID

	// Get signnal for finish
	doneCh := make(chan struct{})
	go func() {
		for {
			select {
			case err := <-consumer.Errors():
				fmt.Println(err)
			case msg := <-consumer.Messages():
				msgCount++
				temp, _, err = codec.NativeFromBinary(msg.Value)
    			if err != nil {
       				fmt.Println(err)
    			}
    			
    			native := temp.(map[string]interface{})
    			temp = nil

    			//Trim values from nested JSON objects
    			claimid.Oid = strings.TrimRight(strings.TrimLeft(native["ClaimID"].(string),`{ "$oid": `) , `"}`)
    			claim.ClaimID = claimid

    			
    			claim.MemberfirstName = native["Memberfirst_name"].(string)
    			claim.MemberlastName = native["Memberlast_name"].(string)
    			claim.Source = native["Source"].(string)
    			claim.Event = native["Event"].(string)
    			claim.Breed = native["Breed"].(string)

    			timeint64, err := strconv.ParseInt(fmt.Sprintf("%v", native["Timestamp"]), 10, 64)
				if err != nil {
    				panic(err)
				}
				claim.TimeStamp = timeint64
				//human readable time-- time.Unix(0, timeint64).String()

    			fmt.Println(claim)
			case <-signals:
				fmt.Println("Interrupt is detected")
				doneCh <- struct{}{}
			}
		}
	}()

	<-doneCh
	fmt.Println("Processed", msgCount, "messages")
}