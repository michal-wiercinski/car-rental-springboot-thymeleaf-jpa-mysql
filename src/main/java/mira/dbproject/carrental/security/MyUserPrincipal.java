package mira.dbproject.carrental.security;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mira.dbproject.carrental.domain.entity.Role;
import mira.dbproject.carrental.domain.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserPrincipal implements UserDetails {

  private User user;

  public MyUserPrincipal(User user) {
    this.user = user;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return getGrantedAuthorities(getPrivileges(user.getRoles()));
  }

  private List<String> getPrivileges(Collection<Role> roles) {
    List<String> rolesName = new ArrayList<>();

    for (Role role : roles) {
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

  public Long getId() {
    return user.getId();
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