package net.kodar.prefabapibase.business.common.transformer;

public interface BaseResultTransformer<OUT, ENT> {

  OUT transform(ENT entity);
}
