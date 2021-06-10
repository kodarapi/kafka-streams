FROM openjdk:11-jre-slim

ARG PROJECT_VERSION=0.0.1-SNAPSHOT

COPY build/libs/kafka-consumer-$PROJECT_VERSION.jar /usr/src/kafka-consumer/kafka-consumer.jar
WORKDIR /usr/src/kafka-consumer
EXPOSE 8080

CMD ["java", "-jar", "kafka-consumer.jar"]
