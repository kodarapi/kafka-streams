package net.kodar.prefabapibase.dataaccess.common;

import java.util.List;

public interface BaseDao<PK, ENT> {

  ENT create(ENT entity);

  ENT getById(PK id);

  List<ENT> list(Long num);

  void update(ENT entity);

  void delete(PK id);

  List<ENT> selectAll();
}
