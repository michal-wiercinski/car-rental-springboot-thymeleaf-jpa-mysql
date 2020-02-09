package mira.dbproject.carrental.security.service;

import java.util.Optional;
import mira.dbproject.carrental.domain.entity.User;
import mira.dbproject.carrental.security.MyUserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService  implements UserDetailsService {

  private final UserService userService;

  public MyUserDetailsService(final UserService userService) {
    this.userService = userService;
  }

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    Optional<User> user = userService.findByEmail(s);
    if (user.isPresent()) {
      return new MyUserPrincipal(user.get());
    }
    throw new UsernameNotFoundException("User: " + s + " is not found");
  }
}
