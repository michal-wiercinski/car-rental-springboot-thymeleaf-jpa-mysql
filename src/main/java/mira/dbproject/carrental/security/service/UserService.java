package mira.dbproject.carrental.security.service;

import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import mira.dbproject.carrental.domain.dto.UserDto;
import mira.dbproject.carrental.domain.entity.User;
import mira.dbproject.carrental.security.MyUserPrincipal;
import mira.dbproject.carrental.security.repository.UserDao;
import mira.dbproject.carrental.security.validation.EmailExistsException;
import mira.dbproject.carrental.service.entityservice.IGenericService;
import mira.dbproject.carrental.service.entityservice.RoleService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IGenericService<User> {

  private final UserDao userDao;
  private final UserDetailService userDetailService;
  private final PasswordEncoder passwordEncoder;

  public UserService(final UserDao userDao,
      final UserDetailService userDetailService,
      final PasswordEncoder passwordEncoder) {
    this.userDao = userDao;
    this.userDetailService = userDetailService;
    this.passwordEncoder = passwordEncoder;
  }

  public Optional<User> findByEmail(String email) {
    return userDao.findByEmail(email);
  }

  @Transactional
  public User registrationNewUser(UserDto userDto) {
    User user = null;
    try {
      user = createByDto(userDto);
      user.setUserDetail(userDetailService.createByUserDetailDto(userDto));
      return save(user);
    } catch (EmailExistsException e) {
      return null;
    }
  }

  private User createByDto(UserDto userDto)
      throws EmailExistsException {
    if (emailExist(userDto.getEmail())) {
      throw new EmailExistsException("There is an account with that email address: "
          + userDto.getEmail());
    }
    User user = new User();
    user.setFirstName(userDto.getFirstName());
    user.setLastName(userDto.getLastName());
    user.setEmail(userDto.getEmail());
    user.setPassword(passwordEncoder.encode(userDto.getPassword()));
    //user.setRoles(Arrays.asList(roleService.findById(3L)));
    return user;
  }

  private boolean emailExist(String email) {
    return findByEmail(email).isPresent();
  }

  @Override
  public List<User> findAll() {
    return userDao.findAll();
  }

  @Override
  public User save(User entity) {
    return userDao.save(entity);
  }

  @Override
  public Optional<User> findById(Long id) {
    return userDao.findById(id);
  }

  @Override
  public void delete(User entity) {

  }

  @Override
  public void deleteById(Long id) {

  }

  @PostConstruct
  public User createSomeUser() {
    UserDto userDto = new UserDto("Michał", "Michał", "michal@michal.pl", "probaHasla",
        "probaHasla", "Wrocław", "Warszawska", "33", "71-000");
    return registrationNewUser(userDto);
  }
}