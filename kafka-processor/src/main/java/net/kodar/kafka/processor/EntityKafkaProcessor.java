package net.kodar.kafka.processor;

import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.streams.serdes.protobuf.KafkaProtobufSerde;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import net.kodar.protobuf.IHelpEntityProtos.IHelpEntity;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class EntityKafkaProcessor {

  private static final String srUrl = "http://schema-registry:8081";

  private KafkaProtobufSerde<IHelpEntity> specificProto() {

    final Map<String, String> config = new HashMap<>(){{
          put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, srUrl);}};

    final KafkaProtobufSerde<IHelpEntity> kafkaProtobufSerde = new KafkaProtobufSerde<>();
    kafkaProtobufSerde.configure(config, false);
    return kafkaProtobufSerde;
  }

  @Autowired
  public Function<KStream<String, IHelpEntity>, KStream<String, IHelpEntity>> entityProcessor() {

    return kstream -> kstream.filter((key, entity) -> {
      System.out.print("Processing... \r\n");
      return true;
    });

  }
}
