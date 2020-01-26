package mira.dbproject.carrental.service.viewservice;

import java.util.List;
import java.util.Optional;
import mira.dbproject.carrental.domain.view.CarViewUser;
import mira.dbproject.carrental.repository.view.CarViewUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarViewUserService implements ICarViewService<CarViewUser> {

  @Autowired
  private CarViewUserDao carViewUserDao;

  @Override
  public List<CarViewUser> findAll() {
    return carViewUserDao.findAll();
  }

  @Override
  public List<CarViewUser> findAllAvailable() {
    return carViewUserDao.findCarViewUserByCarStatusIsLike("available");
  }

  @Override
  public Optional<CarViewUser> findById(Long id) {
    return Optional.empty();
  }


  public Optional<CarViewUser> getCarById(Long id) {
    return carViewUserDao.findById(id);
  }
}
