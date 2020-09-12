IN BASH IN KAFKA DIRECTORY
--------------------
bin/zookeeper-server-start.sh config/zookeeper.properties

bin/kafka-server-start.sh config/server.properties

bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic Claims --from-beginning

IN BASH IN GO APP DIRECTORY
---------------------------
go run producer/main.go

go run consumer/main.go

IN POSTMAN
----------
localhost:3000

REQUEST BODY
------------
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



kill process by port number:
IN CMD
------
netstat -a -o -n

FIND PORT NUMBER AND REPLACE XXXXX WITH PID
-------------------------------------------
taskkill /F /PID XXXXX
