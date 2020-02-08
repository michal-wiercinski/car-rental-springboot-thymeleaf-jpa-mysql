package mira.dbproject.carrental.security.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import mira.dbproject.carrental.domain.UserDto;
import mira.dbproject.carrental.domain.entity.User;
import mira.dbproject.carrental.security.repository.UserDao;
import mira.dbproject.carrental.service.entityservice.IGenericService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IGenericService<User> {

  private final UserDao userDao;
  private final UserDetailService userDetailService;

  public UserService(final UserDao userDao,
      final UserDetailService userDetailService) {
    this.userDao = userDao;
    this.userDetailService = userDetailService;
  }

  public User findByUsername(String username) {
    return userDao.findByUsername(username);
  }

  @Transactional
  public void registrationNewUser(UserDto userDto) {
    User user = createByDto(userDto);
    user.setUserDetail(userDetailService.createByUserDetailDto(userDto));

    save(user);
  }

  private User createByDto(UserDto userDto) {
    User user = new User();
    user.setFirstName(userDto.getFirstName());
    user.setLastName(userDto.getLastName());
    user.setUsername(userDto.getUsername());
    user.setEmail(userDto.getEmail());
    user.setPassword(userDto.getPassword());
    return user;
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

}
