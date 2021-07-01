package net.kodar.prefabapibase.dataaccess.ihelpentity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.kodar.prefabapibase.dataaccess.common.NamedPersistent;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class IHelpEntity extends NamedPersistent {

  private String domain;
  private boolean isDead;
  private String health;
}
