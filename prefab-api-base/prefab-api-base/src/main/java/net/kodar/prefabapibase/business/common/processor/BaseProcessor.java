package net.kodar.prefabapibase.business.common.processor;

public interface BaseProcessor<IN, OUT, PK, VAL> {

  OUT create(IN param);

  OUT get(PK id);

  void update(IN param);

  void delete(PK id);
}
