package net.kodar.prefabapibase.service.ihelpentity;

import java.util.List;
import net.kodar.prefabapibase.business.ihelpentity.processor.IHelpEntityProcessor;
import net.kodar.prefabapibase.dataaccess.ihelpentity.IHelpEntity;
import net.kodar.prefabapibase.service.BaseService;
import net.kodar.prefabapibase.service.ihelpentity.data.IHelpEntityParam;
import net.kodar.prefabapibase.service.ihelpentity.data.IHelpEntityResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/ihelpentity")
public class IHelpEntityService extends
    BaseService<IHelpEntityParam, IHelpEntityResult, IHelpEntity, Long, IHelpEntityProcessor> {

  @Override
  @PostMapping
  public ResponseEntity<IHelpEntityResult> create(@RequestBody IHelpEntityParam param) {
    return super.create(param);
  }

  @Override
  @GetMapping("/list/{num}")
  public ResponseEntity<List<IHelpEntityResult>> listAll(@PathVariable Long num) {
    return super.listAll(num);
  }
}
