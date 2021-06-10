package net.kodar.kafka.service;

import net.kodar.kafka.processor.EntityProcessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entity")
public class EntityService {

  private final EntityProcessor entityProcessor;

  public EntityService(EntityProcessor entityProcessor) {
    this.entityProcessor = entityProcessor;
  }

  @GetMapping("/process")
  public String lookup() {
    entityProcessor.crawl();
    return "IHelpEntity crawler has scrapped your data";
  }
}
