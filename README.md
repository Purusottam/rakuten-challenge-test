# rakuten-challenge-test

Introduction
------------
This repo contains 2 standalone spring-boot projects.

project-1#: challenge
--------------------
It is basically a producer which reads data from a csv file as source and publishes to a specific kafka topic.

project-2#: kafka-dsl-app
-------------------------
It is a kafka stream based consumer that listens to and process the data from the same kafka topic.

Requirements
------------
Consider there is csv file which contains thousands geographic locations (latitude, longitude) along with time.
The task is to read these locations and publish them to a messaging stream/service (like kafka). 
Then prepare a separte app which will consume the data from the messaging service, calculate and display the distance/time to console.

Tools/software/api used
-----------------------
Zookeeper/Kafka (A docker-compose file, see inside /zookeeper-kafka-environment can be used to build up this).
Spring-Boot with dependencies like spring-kafka, spring-cloud-stream, kafka-streams, lombok, opencsv, jackson-data-bind apis etc.

How it works
------------
*a) The zookeeper/kafka environment is set through docker images, defined in the docker-compose.yml file. The command, 'docker-compose up' starts and attaches to containers
   for zookeeper and kafka services against some specified port numbers. This also creates a topic, gpx-topic (specified in docker-compose file) in kafka.
*b) The producer spring-boot app (challenge), refers to its application.yml file to get the required configuration details about kafka like bootstrap-servers, key-serializer,          value-serializer and default-topic etc.
*c) The producer app intenally uses opencsv api to read the supplied csv file, kept inside its classpath resource. It publishes the csv data line by line to the gpx-topic using 
   spring-kafka api.
*d) Similarly, the consumer spring-boot app (kafka-dsl-app), refers its application.yml file to get the required configuration details about the spring-cloud-stream like binding    destination topic etc.
*e) The consumer app internally uses apache kafka-streams api to receive data from the destination topic. After receiving each data from the topic, it calculates the distance
   using Haversine formula and displays that to the console along with time.
