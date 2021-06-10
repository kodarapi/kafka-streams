package net.kodar.kafka.services;

import java.util.function.Consumer;
import net.kodar.kafka.data.entity.IHelpEntity;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EntityKafkaConsumer {

  @Bean
  public Consumer<KStream<String, IHelpEntity>> consumerService() {
    return kstream -> kstream.foreach((key, IHelpEntity) ->
        System.out.printf("IHelpEntity CONSUMED[%s] with Status -> [%s]%n \r\n",
        IHelpEntity.getDomain(),
        IHelpEntity.isDead()));
  }
}
