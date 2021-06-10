package net.kodar.kafka.data.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IHelpEntity implements Serializable {

  boolean isDead;
  private String health;
  private String domain;

}