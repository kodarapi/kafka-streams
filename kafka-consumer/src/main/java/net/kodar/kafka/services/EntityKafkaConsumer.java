package net.kodar.kafka.services;

import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import net.kodar.kafka.data.entity.IHelpEntity;
import net.kodar.kafka.services.mapper.IHelpEntityMapper;
import net.kodar.protobuf.IHelpEntityProtos;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class EntityKafkaConsumer {

  @Autowired
  IHelpEntityMapper entityMapper;

  @Bean
  public Consumer<KStream<String, IHelpEntityProtos.IHelpEntity>> consumerService() {
    return kstream -> kstream.foreach((key, iHelpProto) -> {
      IHelpEntity entity = entityMapper.protoToEntity(iHelpProto);

      System.out.printf(("IHelpEntity CONSUMED[%s] with Status -> [%s]%n \r\n"),
          entity.getDomain(),
          entity.isDead());
    });
  }
}
