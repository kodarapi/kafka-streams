package net.kodar.prefabapibase.business.common.processor;

import java.util.ArrayList;
import java.util.List;

public interface BaseProcessor<IN, OUT, PK> {

  OUT create(IN param);

  OUT get(PK id);

  List<OUT> list(Long num);

  void update(IN param);

  void delete(PK id);
}
