package net.kodar.prefabapibase.dataaccess.common;

import lombok.Data;

@Data
public class NamedPersistent extends Persistent {

  protected Long code;
  protected String name;
  protected String description;
}
