package mira.dbproject.carrental.service.entityservice;

import javax.transaction.Transactional;
import mira.dbproject.carrental.domain.dto.UserDto;
import mira.dbproject.carrental.domain.entity.Address;
import mira.dbproject.carrental.repository.dao.AddressDao;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

  private final AddressDao addressDao;

  public AddressService(final AddressDao addressDao) {
    this.addressDao = addressDao;
  }

  public Address save(Address address) {
    return addressDao.save(address);
  }

  @Transactional
  public Address createAddressByUserDto(UserDto userDto) {
    Address address = new Address();
    address.setCity(userDto.getCity());
    address.setStreet(userDto.getCity());
    address.setHouseNumber(userDto.getHouseNumber());
    address.setZipCode(userDto.getZipCode());
    save(address);
    System.out.println(
        "asssssssssssssssssssssssssssssssssssssssssssssssssssDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDd");
    return address;
  }
}
