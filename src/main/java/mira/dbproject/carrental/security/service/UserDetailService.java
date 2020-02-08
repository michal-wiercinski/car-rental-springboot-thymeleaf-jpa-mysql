package mira.dbproject.carrental.security.service;

import mira.dbproject.carrental.domain.UserDto;
import mira.dbproject.carrental.domain.entity.Address;
import mira.dbproject.carrental.domain.entity.UserDetail;
import mira.dbproject.carrental.security.repository.UserDetailDao;
import mira.dbproject.carrental.service.entityservice.AddressService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements IUserDetailService {

  // private final UserService userService;
  private final UserDetailDao userDetailDao;
  private final AddressService addressService;

  public UserDetailService(final UserDetailDao userDetailDao,
      final AddressService addressService) {
    //   this.userService = userService;
    this.userDetailDao = userDetailDao;
    this.addressService = addressService;
  }

  public UserDetail save(UserDetail userDetail) {
    return userDetailDao.save(userDetail);
  }

  public UserDetail createByUserDetailDto(UserDto userDto) {
    UserDetail userDetail = new UserDetail();
    Address address = addressService.createAddressByUserDto(userDto);
    userDetail.setAddress(address);
    userDetailDao.save(userDetail);
    return userDetail;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
/*
    User user = userService.findByUsername(username);
    if (user != null) {
      return user;
    }
    throw new UsernameNotFoundException("User: " + username + " is not found");
  }
*/
    return null;
  }

}
