package net.kodar.prefabapibase.business.ihelpentity.validator;

import net.kodar.prefabapibase.business.common.validator.BaseParamValidatorImpl;
import net.kodar.prefabapibase.service.ihelpentity.data.IHelpEntityParam;
import org.springframework.stereotype.Component;

@Component
public class IHelpEntityValidator extends BaseParamValidatorImpl<IHelpEntityParam> {

  @Override
  public void validate(IHelpEntityParam entity) {
    super.validate(entity);
    System.out.println("Validating");
  }
}
