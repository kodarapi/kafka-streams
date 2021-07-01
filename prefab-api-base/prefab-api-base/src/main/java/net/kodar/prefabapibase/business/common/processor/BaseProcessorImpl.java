package net.kodar.prefabapibase.business.common.processor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import net.kodar.prefabapibase.business.common.validator.BaseParamValidator;
import net.kodar.prefabapibase.dataaccess.common.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseProcessorImpl<IN, OUT, PK,
    ENT extends Serializable,
    DAO extends BaseDao<PK, ENT>,
    PTR extends BiFunction<IN, ENT, ENT>,
    RTR extends Function<ENT, OUT>>
    implements BaseProcessor<IN, OUT, PK> {

  @Autowired
  protected DAO dao;
  @Autowired
  protected PTR paramTransformer;
  @Autowired
  protected RTR resultTransformer;
  @Autowired
  protected BaseParamValidator<IN> validator;


  @Override
  public OUT create(IN param) {
    validator.validate(param);
    ENT entity = paramTransformer.apply(param, null);
    entity = dao.create(entity);
    return resultTransformer.apply(entity);
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

  @Override
  public List<OUT> list(Long num) {
    List<ENT> entities = dao.list(num);
    return entities.stream().map(resultTransformer).collect(Collectors.<OUT>toList());
  }
}
