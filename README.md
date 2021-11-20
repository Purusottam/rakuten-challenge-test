# rakuten-challenge-test

Introduction
------------
This repo contains 2 standalone experimental spring-boot projects.

ptoject1#: challenge 
Its basically a producer which reads data from a csv file as source and publishes to a specific kafka topic.
project2#: kafka-dsl-app
Its a kafka stream based consumer that listens to and process the data from the same kafka topic.

Requirements
------------
Consider there is csv file which contains thousands geographic location data (latitude, longitude) along with time.
The task is to read this data line by line and publish them to a messaging stream/service (like kafka). 
Then prepare a separte app which will consume the data from  the messaging service, calculate and display the distance to a console.

Tools/software/api used
-----------------------
Zookeeper/Kafka (A docker-compose file can be used to build up this).
Spring-Boot with dependencies like spring-kafka, spring-cloud-stream, kafka-streams, lombok, opencsv, jackson data bind apis etc.
