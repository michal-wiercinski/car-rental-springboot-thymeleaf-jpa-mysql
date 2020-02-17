package mira.dbproject.carrental.mapper;

import mira.dbproject.carrental.domain.dto.RoleDto;
import mira.dbproject.carrental.domain.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {


  public RoleDto mapEntityToDto(Role role){
    RoleDto roleDto = new RoleDto();
    roleDto.setId(role.getId());
    role.setName(role.getName());

    return roleDto;
  }

}
