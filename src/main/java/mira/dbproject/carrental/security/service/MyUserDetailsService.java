package mira.dbproject.carrental.security.service;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import javax.transaction.Transactional;
import mira.dbproject.carrental.domain.entity.User;
import mira.dbproject.carrental.security.MyUserPrincipal;
import mira.dbproject.carrental.service.entityservice.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  private final RoleService roleService;
  private final UserService userService;

  public MyUserDetailsService(
      final RoleService roleService,
      final UserService userService) {
    this.roleService = roleService;
    this.userService = userService;
  }

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    Optional<User> user = userService.findByEmail(s);
    if (user.isPresent()) {
      logger.info("User {} has been found", user.get().getEmail());
      MyUserPrincipal myUserPrincipal = new MyUserPrincipal(user.get());
      logger.info("User {} has been found", user.get().getEmail());
      return new org.springframework.security.core.userdetails.User(
          myUserPrincipal.getUsername(),
          myUserPrincipal.getPassword(),
          myUserPrincipal.isEnabled(),
          myUserPrincipal.isAccountNonExpired(),
          myUserPrincipal.isCredentialsNonExpired(),
          myUserPrincipal.isAccountNonLocked(),
          myUserPrincipal.getAuthorities());
    } else {
      throw new UsernameNotFoundException(String.format("User: %s is not found", s));
    }
  }
}
