package mira.dbproject.carrental.service.entityservice;

import mira.dbproject.carrental.domain.entity.Role;
import mira.dbproject.carrental.repository.dao.RoleDao;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

  private final RoleDao roleDao;

  public RoleService(final RoleDao roleDao) {
    this.roleDao = roleDao;
  }

  public Role findById(Long id){
    return roleDao.findById(id).get();
  }
}
