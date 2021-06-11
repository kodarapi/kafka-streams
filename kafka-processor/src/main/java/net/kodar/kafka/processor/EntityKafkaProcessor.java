package net.kodar.kafka.processor;

import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import net.kodar.kafka.data.entity.IHelpEntity;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class EntityKafkaProcessor {

  @Bean
  public Function<KStream<String, IHelpEntity>, KStream<String, IHelpEntity>> entityProcessor() {

    return kstream -> kstream.filter((key, IHelpEntity) -> {
      log.debug("Processing...");

      return IHelpEntity.getDomain() != null;
    });
  }
}
