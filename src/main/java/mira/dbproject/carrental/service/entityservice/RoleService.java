package mira.dbproject.carrental.service.entityservice;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import mira.dbproject.carrental.domain.dto.RoleDto;
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


  public Collection<? extends RoleDto> getRoleDtoForUser(Collection<Role> roles) {
    return roles.stream().map(roleMapper::mapEntityToDto).collect(
        Collectors.toCollection(HashSet::new));
  }

}
