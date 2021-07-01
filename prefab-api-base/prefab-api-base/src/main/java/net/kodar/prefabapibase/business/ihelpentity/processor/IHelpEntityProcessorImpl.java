package net.kodar.prefabapibase.business.ihelpentity.processor;

import net.kodar.prefabapibase.business.common.processor.BaseProcessorImpl;
import net.kodar.prefabapibase.business.ihelpentity.transformer.IHelpEntityParamTransformer;
import net.kodar.prefabapibase.business.ihelpentity.transformer.IHelpEntityResultTransformer;
import net.kodar.prefabapibase.dataaccess.ihelpentity.IHelpEntity;
import net.kodar.prefabapibase.dataaccess.ihelpentity.dao.IHelpEntityDao;
import net.kodar.prefabapibase.service.ihelpentity.data.IHelpEntityParam;
import net.kodar.prefabapibase.service.ihelpentity.data.IHelpEntityResult;
import org.springframework.stereotype.Component;

@Component
public class IHelpEntityProcessorImpl extends
    BaseProcessorImpl<IHelpEntityParam, IHelpEntityResult, Long, IHelpEntity, IHelpEntityDao, IHelpEntityParamTransformer, IHelpEntityResultTransformer> implements
    IHelpEntityProcessor {

}
