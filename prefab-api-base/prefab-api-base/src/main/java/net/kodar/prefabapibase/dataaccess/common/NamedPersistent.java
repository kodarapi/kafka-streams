package net.kodar.prefabapibase.dataaccess.common;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class NamedPersistent extends Persistent {

  protected Long code;
  protected String name;
  protected String description;
}
