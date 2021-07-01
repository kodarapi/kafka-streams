package net.kodar.prefabapibase.business.ihelpentity.transformer;

import net.kodar.prefabapibase.business.common.transformer.BaseParamTransformerImpl;
import net.kodar.prefabapibase.business.ihelpentity.mapper.IHelpEntityMapper;
import net.kodar.prefabapibase.dataaccess.ihelpentity.IHelpEntity;
import net.kodar.prefabapibase.service.ihelpentity.data.IHelpEntityParam;
import net.kodar.prefabapibase.service.ihelpentity.data.IHelpEntityResult;
import org.springframework.stereotype.Component;

@Component
public class IHelpEntityParamTransformer extends
    BaseParamTransformerImpl<IHelpEntityParam, IHelpEntityResult, IHelpEntity, IHelpEntityMapper> {

}
