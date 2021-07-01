package net.kodar.prefabapibase.service;

import java.util.List;
import java.util.Objects;
import net.kodar.prefabapibase.business.common.processor.BaseProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class BaseService<IN, OUT, ENT, PK, P extends BaseProcessor<IN, OUT, PK>> {

  @Autowired
  protected P processor;

  public ResponseEntity<OUT> create(final IN param) {
    validateParameters(param);
    OUT result = processor.create(param);
    return ResponseEntity.ok(result);
  }

  public ResponseEntity<List<OUT>> listAll(Long num) {
    List<OUT> result = processor.list(num);

    return ResponseEntity.ok(result);
  }

  private void validateParameters(IN param) {
    Objects.requireNonNull(param);
  }

}
