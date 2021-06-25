package net.kodar.prefabapibase.business.common.transformer;

public interface BaseParamTransformer<IN, ENT> {

  ENT transform(IN param);

}
