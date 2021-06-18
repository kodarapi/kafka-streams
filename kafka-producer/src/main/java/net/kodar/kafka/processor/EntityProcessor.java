package net.kodar.kafka.processor;

import net.kodar.protobuf.IHelpEntityProtos;
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
  private final KafkaTemplate<String, IHelpEntityProtos.IHelpEntity> kafkaTemplate;
  private final Random random = new Random();

  public EntityProcessor(KafkaTemplate<String, IHelpEntityProtos.IHelpEntity> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  @SneakyThrows
  public void produceMessage() {

    while (true) {
      Thread.sleep(2000);
      IHelpEntity entity = new IHelpEntity(random.nextBoolean(),
          UUID.randomUUID().toString(), UUID.randomUUID().toString());

      IHelpEntityProtos.IHelpEntity message =
          IHelpEntityProtos.IHelpEntity.newBuilder()
              .setDomain(entity.getDomain())
              .setHealth(entity.getHealth())
              .setIsDead(entity.isDead())
              .build();

      kafkaTemplate.send(KAFKA_TOPIC, message);

      System.out.printf("IHelpEntity PRODUCED[%s] with Status -> [%s]%n \r\n",
          message.getDomain(),
          message.getIsDead());
    }
  }
}
