FROM openjdk:11
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} kafka-dsl.jar
ENTRYPOINT ["java","-jar","kafka-dsl.jar"]