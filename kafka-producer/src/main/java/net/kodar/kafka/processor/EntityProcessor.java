package net.kodar.kafka.processor;

import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import net.kodar.kafka.data.entity.IHelpEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EntityProcessor {

  private static final String KAFKA_TOPIC = "web-domains";
  private final KafkaTemplate<String, IHelpEntity> kafkaTemplate;

  public EntityProcessor(KafkaTemplate<String, IHelpEntity> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void produceMessage() {

    List<IHelpEntity> IHelpEntities = Arrays
        .asList(new IHelpEntity(true, "Hello", "Borka"),
            new IHelpEntity(false, "this is a", "kstream test"));

    IHelpEntities
        .forEach(IHelpEntity -> {
          kafkaTemplate.send(KAFKA_TOPIC, IHelpEntity);
          log.debug("IHelpEntity message" + IHelpEntity.getDomain());
        });

  }
}
