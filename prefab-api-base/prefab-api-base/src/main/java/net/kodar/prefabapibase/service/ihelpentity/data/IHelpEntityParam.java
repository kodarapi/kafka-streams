package net.kodar.prefabapibase.service.ihelpentity.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.kodar.prefabapibase.service.common.data.BaseData;

@EqualsAndHashCode(callSuper = true)
@Data
public class IHelpEntityParam extends BaseData {

  private String domain;
  private boolean isDead;
  private String health;
}

