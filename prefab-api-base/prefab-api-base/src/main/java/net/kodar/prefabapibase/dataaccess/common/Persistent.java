package net.kodar.prefabapibase.dataaccess.common;

import java.io.Serializable;
import lombok.Data;

@Data
public class Persistent implements Serializable {

  protected Long id;
}
