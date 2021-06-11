package net.kodar.kafka.processor;

import java.util.Random;
import java.util.UUID;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.kodar.kafka.data.entity.IHelpEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EntityProcessor {

  private static final String KAFKA_TOPIC = "web-domains";
  private final KafkaTemplate<String, IHelpEntity> kafkaTemplate;
  private final Random random = new Random();

  public EntityProcessor(KafkaTemplate<String, IHelpEntity> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  @SneakyThrows
  public void produceMessage() {

    while (true) {
      Thread.sleep(2000);
      IHelpEntity entity = new IHelpEntity(random.nextBoolean(),
          UUID.randomUUID().toString(),
          UUID.randomUUID().toString());

      kafkaTemplate.send(KAFKA_TOPIC, entity);

      System.out.printf("IHelpEntity PRODUCED[%s] with Status -> [%s]%n \r\n",
          entity.getDomain(),
          entity.isDead());
    }
  }
}
