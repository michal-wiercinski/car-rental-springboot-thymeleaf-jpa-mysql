package mira.dbproject.carrental.security.service;

import java.util.Optional;
import mira.dbproject.carrental.domain.entity.User;
import mira.dbproject.carrental.security.MyUserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  private final UserService userService;

  public MyUserDetailsService(final UserService userService) {
    this.userService = userService;
  }

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    Optional<User> user = userService.findByEmail(s);
    if (user.isPresent()) {
      logger.info("User {} has been found", user.get().getEmail());
      return new MyUserPrincipal(user.get());
    } else {
      throw new UsernameNotFoundException(String.format("User: %s is not found", s));
    }
  }
}
