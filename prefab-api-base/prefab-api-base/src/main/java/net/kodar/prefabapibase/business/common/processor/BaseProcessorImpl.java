package net.kodar.prefabapibase.business.common.processor;

public abstract class BaseProcessorImpl<IN, OUT, PK, VAL> implements BaseProcessor<IN, OUT, PK, VAL> {

  @Override
  public OUT create(IN param) {
    return null;
  }

  @Override
  public OUT get(PK id) {
    return null;
  }

  @Override
  public void update(IN param) {

  }

  @Override
  public void delete(PK id) {

  }
}
