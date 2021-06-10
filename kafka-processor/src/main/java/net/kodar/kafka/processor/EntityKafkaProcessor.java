package net.kodar.kafka.processor;

import java.util.function.Function;
import net.kodar.kafka.data.entity.IHelpEntity;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EntityKafkaProcessor {

  @Bean
  public Function<KStream<String, IHelpEntity>, KStream<String, IHelpEntity>> entityProcessor() {

    return kstream -> kstream.filter((key, entity) -> {
      System.out.println("Processing... \r\n");

      return !entity.isDead();
    });

  }
}
