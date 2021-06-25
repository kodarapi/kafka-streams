package net.kodar.prefabapibase.business.common.validator;

import java.util.Objects;

public class BaseParamValidatorImpl<ENT> implements BaseParamValidator {


  @Override
  public void validate(Object entity) {
    Objects.requireNonNull(entity);
  }
}
