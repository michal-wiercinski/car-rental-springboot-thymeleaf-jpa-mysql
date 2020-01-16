package mira.dbproject.carrental.service.viewservice;

import java.util.List;
import mira.dbproject.carrental.domain.view.CarViewAdmin;
import mira.dbproject.carrental.repository.dao.CarViewAdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarViewAdminService implements ICarViewService<CarViewAdmin> {

  @Autowired
  CarViewAdminDao carViewAdminDao;

  @Override
  public List<CarViewAdmin> findAll() {
    return carViewAdminDao.findAll();
  }
}