package net.kodar.prefabapibase.business.common.validator;

public interface Validator<ENT> {

  void validate(ENT entity);

}
