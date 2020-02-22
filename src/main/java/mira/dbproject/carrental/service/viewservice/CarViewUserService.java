package mira.dbproject.carrental.service.viewservice;

import java.util.List;
import java.util.Optional;
import mira.dbproject.carrental.domain.view.CarViewUser;
import mira.dbproject.carrental.repository.view.CarViewUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class CarViewUserService implements ICarViewService<CarViewUser> {

  @Autowired
  private CarViewUserDao carViewUserDao;

  @Override
  public List<CarViewUser> findAll() {
    return carViewUserDao.findAll();
  }

  public List<CarViewUser> findAllAvailable() {
    return carViewUserDao.findCarViewUserByCarStatusIsLike("available");
  }

  @Override
  public Optional<CarViewUser> findById(Long id) {
    return Optional.empty();
  }

  @Override
  public List<CarViewUser> findAllAndSortByParam(String sort, String direction) {
    if (!sort.isEmpty()) {
      if (!direction.isEmpty() && direction.equals(Direction.DESC.toString())) {
        return carViewUserDao.findAll(Sort.by(sort).descending());
      }
      return carViewUserDao.findAll(Sort.by(sort).ascending());
    }
    return carViewUserDao.findAll();
  }

}
