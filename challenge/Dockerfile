FROM openjdk:11
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} csv-kafka-producer.jar
ENTRYPOINT ["java", "-jar", "csv-kafka-producer.jar"]