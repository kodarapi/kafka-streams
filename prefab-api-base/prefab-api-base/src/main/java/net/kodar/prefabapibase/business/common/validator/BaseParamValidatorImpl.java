package net.kodar.prefabapibase.business.common.validator;

import java.util.Objects;

public class BaseParamValidatorImpl<IN> implements BaseParamValidator<IN> {


  @Override
  public void validate(IN entity) {
    Objects.requireNonNull(entity);
  }
}
