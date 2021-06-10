FROM openjdk:11-jre-slim

ARG PROJECT_VERSION=0.0.1-SNAPSHOT

COPY build/libs/kafka-processor-$PROJECT_VERSION.jar /usr/src/kafka-processor/kafka-processor.jar
WORKDIR /usr/src/kafka-processor
EXPOSE 8802

CMD ["java", "-jar", "kafka-processor.jar"]
