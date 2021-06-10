package net.kodar.kafka.processor;

import java.util.Arrays;
import java.util.List;
import net.kodar.kafka.data.entity.IHelpEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EntityProcessor {

  private final String KAFKA_TOPIC = "web-domains";
  private final KafkaTemplate<String, IHelpEntity> kafkaTemplate;

  public EntityProcessor(KafkaTemplate<String, IHelpEntity> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void crawl() {

    List<IHelpEntity> IHelpEntities = Arrays
        .asList(new IHelpEntity(true, "Hello", "Borka"),
            new IHelpEntity(false, "this is a", "kstream test"));

    IHelpEntities
        .forEach(IHelpEntity -> {
          kafkaTemplate.send(KAFKA_TOPIC, IHelpEntity);
          System.out.println("IHelpEntity message" + IHelpEntity.getDomain());
        });

  }
}
