package net.kodar.prefabapibase.dataaccess.ihelpentity.dao;

import net.kodar.prefabapibase.dataaccess.common.BaseDaoKafkaImpl;
import net.kodar.prefabapibase.dataaccess.ihelpentity.IHelpEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class IHelpEntityDaoImpl extends BaseDaoKafkaImpl<Long, IHelpEntity> implements
    IHelpEntityDao {


  public IHelpEntityDaoImpl(
      KafkaTemplate<String, IHelpEntity> kafkaTemplate) {
    super(kafkaTemplate);
  }

}
