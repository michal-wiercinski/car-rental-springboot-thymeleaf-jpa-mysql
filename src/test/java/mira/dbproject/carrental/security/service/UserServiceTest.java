/*
package mira.dbproject.carrental.security.service;

import mira.dbproject.carrental.domain.dto.UserDto;
import mira.dbproject.carrental.security.repository.UserDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UserServiceTest {

  private UserDao userDao = Mockito.mock(UserDao.class);
  private UserDetailService userDetailService = Mockito.mock(UserDetailService.class);
  UserService userService = new UserService(userDao, userDetailService);


  @Test
  public void checkIfSave() {
    UserDto userDto = new UserDto();
    userDto.setUsername("aqwerty");
    userDto.setFirstName("Mmm");
    userDto.setLastName("NNN");
    userDto.setEmail("aaaa@aaaa.com");
    userDto.setPassword("aaa1");
    userDto.setConfirmPassword("aaa1");
    userDto.setStreet("zzz");
    userDto.setHouseNumber("1");
    userDto.setCity("aaa");
    userDto.setZipCode("11-111");

    int start = userService.findAll().size();

    userService.registrationNewUser(userDto);

    int expected = userService.findAll().size();

    Assertions.assertNotEquals(start, expected);
  }

}*/
