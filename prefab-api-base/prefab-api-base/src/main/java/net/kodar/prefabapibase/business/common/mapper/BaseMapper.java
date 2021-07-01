package net.kodar.prefabapibase.business.common.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

public interface BaseMapper<IN,OUT,ENT> {

  OUT entityToResult(ENT entity);

  ENT paramToEntity(IN param);

  void updateEntityFromParam(IN param, @MappingTarget ENT original);


}
