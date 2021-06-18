package net.kodar.kafka.service;

import io.confluent.kafka.serializers.protobuf.KafkaProtobufDeserializer;
import java.util.Properties;
import net.kodar.kafka.processor.EntityProcessor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entity")
public class EntityService {

  private final EntityProcessor entityProcessor;

  public EntityService(EntityProcessor entityProcessor) {
    this.entityProcessor = entityProcessor;
  }

  @GetMapping("/process")
  public String lookup() {
    entityProcessor.produceMessage();


    //TODO -> docker-compose -> registry config -> .proto -> generate class ?

    return "IHelpEntity crawler has scrapped your data";
  }
}
