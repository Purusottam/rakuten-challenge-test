# rakuten-challenge-test

Introduction
------------
This repo contains 2 standalone spring-boot projects.

project-1#: challenge
--------------------
Its basically a producer which reads data from a csv file as source and publishes to a specific kafka topic.

project-2#: kafka-dsl-app
-------------------------
Its a kafka stream based consumer that listens to and process the data from the same kafka topic.

Requirements
------------
Consider there is csv file which contains thousands geographic locations (latitude, longitude) along with time.
The task is to read these locations and publish them to a messaging stream/service (like kafka). 
Then prepare a separte app which will consume the data from the messaging service, calculate and display the distance/time to console.

Tools/software/api used
-----------------------
Zookeeper/Kafka (A docker-compose file, see inside /zookeeper-kafka-environment can be used to build up this).
Spring-Boot with dependencies like spring-kafka, spring-cloud-stream, kafka-streams, lombok, opencsv, jackson-data-bind apis etc.
