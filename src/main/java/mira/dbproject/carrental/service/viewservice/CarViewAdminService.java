package mira.dbproject.carrental.service.viewservice;

import java.util.List;
import java.util.Optional;
import mira.dbproject.carrental.domain.view.CarViewAdmin;
import mira.dbproject.carrental.repository.view.CarViewAdminDao;
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

  @Override
  public List<CarViewAdmin> findAllAvailable() {
    return null;
  }

  @Override
  public Optional<CarViewAdmin> findById(Long id) {
    return carViewAdminDao.findById(id);
  }


}