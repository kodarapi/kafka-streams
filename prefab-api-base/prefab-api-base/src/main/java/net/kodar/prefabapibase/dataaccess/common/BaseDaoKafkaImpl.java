package net.kodar.prefabapibase.dataaccess.common;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import lombok.RequiredArgsConstructor;
import net.kodar.prefabapibase.dataaccess.ihelpentity.IHelpEntity;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.apache.kafka.connect.json.JsonSerializer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@RequiredArgsConstructor
public abstract class BaseDaoKafkaImpl<PK, ENT> implements BaseDao<PK, ENT> {

  protected static final String KAFKA_TOPIC = "web-domains";
  protected final KafkaTemplate<String, ENT> kafkaTemplate;

  @Override
  public ENT create(ENT entity) {
    kafkaTemplate.send(KAFKA_TOPIC, entity);
    return entity;
  }

  @Override
  public ENT getById(PK id) {
    return null;
  }

  @Override
  public void update(ENT entity) {

  }

  @Override
  public void delete(PK id) {

  }

  @Override
  public List<ENT> list(Long num) {
    ArrayList<ENT> entities = new ArrayList<>();

    Properties properties = new Properties();
    properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    properties.put(ConsumerConfig.GROUP_ID_CONFIG, "protobuf-consumer-group");
    properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
    properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
    properties.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
    properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

    KafkaConsumer<String, ENT> consumer = new KafkaConsumer<>(properties);
    TopicPartition topicPartition = new TopicPartition(KAFKA_TOPIC, 0);
    consumer.assign(Collections.singleton(topicPartition));
    for (int i = 0; i < 2; i++) {

      consumer.seekToEnd(Collections.singleton(topicPartition));
      long endPosition = consumer.position(topicPartition);
      long recentMessagesStartPosition = endPosition - num;
      consumer.seek(topicPartition, recentMessagesStartPosition);

      ConsumerRecords<String, ENT> records = consumer.poll(Duration.ofMillis(0));
      records.forEach((value) -> entities.add(value.value()));
    }

    consumer.commitAsync();
    consumer.close();
    return entities;

  }

  @Override
  public List<ENT> selectAll() {
    return new ArrayList<>();
  }
}
