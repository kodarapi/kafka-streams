package net.kodar.kafka.services;

import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import net.kodar.kafka.data.entity.IHelpEntity;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class EntityKafkaConsumer {

  @Bean
  public Consumer<KStream<String, IHelpEntity>> consumerService() {
    return kstream -> kstream.foreach((key, iHelpEntity) ->
        System.out.printf(("IHelpEntity CONSUMED[%s] with Status -> [%s]%n \r\n"),
            iHelpEntity.getDomain(),
            iHelpEntity.isDead()));
  }
}
