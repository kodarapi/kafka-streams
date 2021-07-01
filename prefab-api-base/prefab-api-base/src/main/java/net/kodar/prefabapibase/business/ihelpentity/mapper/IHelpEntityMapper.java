package net.kodar.prefabapibase.business.ihelpentity.mapper;

import net.kodar.prefabapibase.business.common.mapper.BaseMapper;
import net.kodar.prefabapibase.dataaccess.ihelpentity.IHelpEntity;
import net.kodar.prefabapibase.service.ihelpentity.data.IHelpEntityParam;
import net.kodar.prefabapibase.service.ihelpentity.data.IHelpEntityResult;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IHelpEntityMapper extends
    BaseMapper<IHelpEntityParam, IHelpEntityResult, IHelpEntity> {

}
