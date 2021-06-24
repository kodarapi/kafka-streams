package net.kodar.prefabapibase.dataaccess.common;

import java.util.List;

public abstract class BaseDaoJpaImpl<PK, ENT> implements BaseDao<PK, ENT>{

  @Override
  public ENT create(ENT entity) {
    return null;
  }

  @Override
  public ENT get(PK id) {
    return null;
  }

  @Override
  public void update(ENT entity) {

  }

  @Override
  public void delete(PK id) {

  }

  @Override
  public List<ENT> selectAll() {
    return null;
  }
}
