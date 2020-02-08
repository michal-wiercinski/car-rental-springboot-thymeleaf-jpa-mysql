package mira.dbproject.carrental.security.service;

import mira.dbproject.carrental.domain.UserDto;
import mira.dbproject.carrental.domain.entity.Address;
import mira.dbproject.carrental.domain.entity.UserDetail;
import mira.dbproject.carrental.security.repository.UserDetailDao;
import mira.dbproject.carrental.service.entityservice.AddressService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService {

  private final UserDetailDao userDetailDao;
  private final AddressService addressService;

  public UserDetailService(final UserDetailDao userDetailDao,
      final AddressService addressService) {
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
}
