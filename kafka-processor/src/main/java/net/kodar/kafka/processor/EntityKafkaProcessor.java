package net.kodar.kafka.processor;

import java.util.function.Function;
import net.kodar.kafka.data.entity.IHelpEntity;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.SendTo;

@Configuration
public class EntityKafkaProcessor {

  @Bean
  @SendTo("")
  public Function<KStream<String, IHelpEntity>, KStream<String, IHelpEntity>> entityProcessor() {

    return kstream -> kstream.filter((key, IHelpEntity) -> {
      System.out.println("Processing...");

      return IHelpEntity.getDomain() != null;
    });

  }
}
