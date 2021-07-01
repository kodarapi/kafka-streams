package net.kodar.prefabapibase.business.common.transformer;

import java.util.function.Function;
import net.kodar.prefabapibase.business.common.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseResultTransformerImpl<IN, OUT, ENT, MAP extends BaseMapper<IN,OUT,ENT>> implements Function<ENT, OUT> {

  @Autowired
  protected MAP autoMapper;

  @Override
  public OUT apply(ENT entity) {
    if (entity == null) {
      return null;
    }

    return autoMapper.entityToResult(entity);
  }
}
