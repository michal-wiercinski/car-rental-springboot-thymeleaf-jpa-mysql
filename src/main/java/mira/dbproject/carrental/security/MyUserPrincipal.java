package mira.dbproject.carrental.security;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mira.dbproject.carrental.domain.dto.RoleDto;
import mira.dbproject.carrental.domain.entity.Role;
import mira.dbproject.carrental.domain.entity.User;
import mira.dbproject.carrental.service.entityservice.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserPrincipal implements UserDetails {

  private User user;

  @Autowired
  RoleService roleService;

  public MyUserPrincipal(User user) {
    this.user = user;
  }


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
 /*   final Set<GrantedAuthority> authorities = new HashSet<>();
    Set<RoleDto> roleDtos = roleService.getRoleDtoForUser(user.getRoles());
    System.out.println(roleDtos.size());
    for (final RoleDto roleDto : roleDtos) {
      authorities.add(new SimpleGrantedAuthority(roleDto.getName()));
    }
    return authorities;*/
    return getGrantedAuthorities(getPrivileges(user.getRoles()));

  }

 /* public Collection<? extends GrantedAuthority> getAuthorities() {

    return getGrantedAuthorities(getPrivileges(user.getRoles()));
  }*/

  private List<String> getPrivileges(Collection<Role> roles) {
    System.out
        .println(roles.size() + "asdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    List<String> rolesName = new ArrayList<>();

    for (Role role :roles) {
      rolesName.add(role.getName());
    }
    return rolesName;
  }

  private Collection<GrantedAuthority> getGrantedAuthorities(List<String> rolesName) {
    List<GrantedAuthority> authorities = new ArrayList<>();
    for (String roleName : rolesName) {
      authorities.add(new SimpleGrantedAuthority(roleName));
    }
    return authorities;
  }


  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getEmail();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}