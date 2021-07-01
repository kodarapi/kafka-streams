package net.kodar.prefabapibase.business.ihelpentity.transformer;

import net.kodar.prefabapibase.business.common.transformer.BaseResultTransformerImpl;
import net.kodar.prefabapibase.business.ihelpentity.mapper.IHelpEntityMapper;
import net.kodar.prefabapibase.dataaccess.ihelpentity.IHelpEntity;
import net.kodar.prefabapibase.service.ihelpentity.data.IHelpEntityParam;
import net.kodar.prefabapibase.service.ihelpentity.data.IHelpEntityResult;
import org.springframework.stereotype.Component;

@Component
public class IHelpEntityResultTransformer extends
    BaseResultTransformerImpl<IHelpEntityParam, IHelpEntityResult, IHelpEntity, IHelpEntityMapper> {

}
