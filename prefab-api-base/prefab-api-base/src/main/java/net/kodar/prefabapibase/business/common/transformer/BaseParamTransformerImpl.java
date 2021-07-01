package net.kodar.prefabapibase.business.common.transformer;

import java.util.function.BiFunction;
import net.kodar.prefabapibase.business.common.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseParamTransformerImpl<IN,OUT, ENT, MAP extends BaseMapper<IN,OUT,ENT>> implements BiFunction<IN, ENT, ENT> {

  @Autowired
  protected MAP autoMapper;

  @Override
  public ENT apply(IN param, ENT original) {

    if (original == null) {
      return autoMapper.paramToEntity(param);
    } else {
      autoMapper.updateEntityFromParam(param, original);
      return original;
    }
  }
}
