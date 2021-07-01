package net.kodar.prefabapibase;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class PrefabApiBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrefabApiBaseApplication.class, args);
	}

	@Bean
	public NewTopic topic(){
		return TopicBuilder.name("web-domains").partitions(1).replicas(1).build();
	}

}
