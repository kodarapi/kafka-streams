FROM openjdk:11-jre-slim

ARG PROJECT_VERSION=0.0.1-SNAPSHOT

COPY build/libs/kafka-producer-$PROJECT_VERSION.jar /usr/src/kafka-producer/kafka-producer.jar
WORKDIR /usr/src/kafka-producer
EXPOSE 8080

CMD ["java", "-jar", "kafka-producer.jar"]
