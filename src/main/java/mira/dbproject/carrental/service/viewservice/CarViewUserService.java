package mira.dbproject.carrental.service.viewservice;

import java.util.List;
import mira.dbproject.carrental.domain.view.CarViewUser;
import mira.dbproject.carrental.repository.dao.CarViewUserDao;
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
}
