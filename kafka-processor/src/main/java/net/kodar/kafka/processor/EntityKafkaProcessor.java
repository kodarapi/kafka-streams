package net.kodar.kafka.processor;

import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import net.kodar.kafka.data.entity.IHelpEntity;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class EntityKafkaProcessor {


  @Bean
  public Consumer<KStream<String, IHelpEntity>> entityProcessor() {

    return kstream ->
    {
      KStream<String, IHelpEntity>[] branches = kstream.branch(
          (id, orderValue) -> orderValue.isDead(),
          (id, orderValue) -> !orderValue.isDead());

      branches[0].to("inactive.web-domains");
      branches[1].to("active.web-domains");
    };
  }
}
