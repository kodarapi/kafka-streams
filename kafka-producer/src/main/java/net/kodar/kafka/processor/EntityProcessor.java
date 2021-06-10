package net.kodar.kafka.processor;

import java.util.Random;
import java.util.UUID;
import lombok.SneakyThrows;
import net.kodar.kafka.data.entity.IHelpEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EntityProcessor {

  private final static String KAFKA_TOPIC = "web-domains";
  private final KafkaTemplate<String, IHelpEntity> kafkaTemplate;

  public EntityProcessor(KafkaTemplate<String, IHelpEntity> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  @SneakyThrows
  public void crawl() {
    Random random = new Random();

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
