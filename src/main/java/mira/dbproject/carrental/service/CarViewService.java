package mira.dbproject.carrental.service;

import java.util.Collection;
import mira.dbproject.carrental.domain.CarView;
import mira.dbproject.carrental.repository.dao.CarViewDao;
import org.springframework.beans.factory.annotation.Autowired;

public class CarViewService {

  @Autowired
  CarViewDao carViewDao;

  public Collection<CarView> findAll(){
    return carViewDao.findAll();
  }

}
