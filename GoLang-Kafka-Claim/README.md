# Simple-Avro-Kafka-Golang

![demo](simple-avro-kafka-golang-demo.gif)

This repository created to show the example for using [Avro](https://avro.apache.org/) for serialization & [Kafka](http://kafka.apache.org/) for publish-subscribe messaging with ([Golang](https://golang.org/)) as Simple Producer and Consumer

# Running Kafka
Download the latest Kafka version from this link [Kafka Download Page](http://kafka.apache.org/downloads.html) and choose the binary downloads.

	    > Extract the binaries into some folder. For the example in project/kafka.
		> Go to your kafka extract directory.
        > Start the Zookeeper server with this command `bin/zookeeper-server-start.sh config/zookeeper.properties`
        > Start the Kafka server with this command `bin/kafka-server-start.sh config/server.properties`
        > Create the topic : `bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic simple-avro-kafka-golang`
        > If you want to show the topic list, you can using this command `bin/kafka-topics.sh --list --zookeeper localhost:2181`
        > Start simple producer for publish message to the topic `bin/kafka-console-producer.sh --broker-list localhost:9092 --topic simple-avro-kafka-golang`
        > start simple consumer that can consume message from the topic, `bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic simple-avro-kafka-golang --from-beginning`
        list consumers 'bin/kafka-consumer-groups.sh  --list --bootstrap-server localhost:9092'

# Running Simple Kafka Producer using Golang

	    > Make sure Running Kafka step already done.
        > Go to your kafka producer directory.
        > start using go run main.go
		
		
# Running Simple Kafka Consumer using Golang

	    > Make sure Running Kafka step already done.
		> Go to your kafka consumer directory.
		> start using go run main.go
		
# Send Testing Message using POSTMAN
Make sure you already have [POSTMAN](https://www.getpostman.com/)

	    > Open your POSTMAN.
		> Fill the url with localhost:3000 and choose POST method
		> Select Body tab and choose raw JSON (application/json) and then try to send message with JSON data
		{
			"ClaimID":{
					"$oid":"5ba8d26bfc13ae5488000560"
				},
			"Memberfirst_name":"Allissa",
			"Memberlast_name":"Redholes",
			"Source":"CenPas",
			"Event":"Medical Management",
			"Breed":"Curabitur convallis. Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.",
			"TimeStamp":null
		}
