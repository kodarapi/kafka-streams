package net.kodar.prefabapibase.dataaccess.ihelpentity;

import lombok.Data;
import net.kodar.prefabapibase.dataaccess.common.NamedPersistent;

@Data
public class IHelpEntity extends NamedPersistent {

  private String domain;
  private boolean isDead;
  private String health;
}
