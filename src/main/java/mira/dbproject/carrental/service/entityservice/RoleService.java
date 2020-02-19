package mira.dbproject.carrental.service.entityservice;

import mira.dbproject.carrental.domain.entity.Role;
import mira.dbproject.carrental.mapper.RoleMapper;
import mira.dbproject.carrental.repository.dao.RoleDao;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

  private final RoleDao roleDao;

  private final RoleMapper roleMapper;

  public RoleService(final RoleDao roleDao, final RoleMapper roleMapper) {
    this.roleDao = roleDao;
    this.roleMapper = roleMapper;
  }

  public Role findById(Long id) {
    return roleDao.findById(id).get();
  }
}
