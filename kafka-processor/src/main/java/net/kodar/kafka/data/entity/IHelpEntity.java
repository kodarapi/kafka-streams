package net.kodar.kafka.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IHelpEntity {
  boolean isDead;
  private String health;
  private String domain;

}