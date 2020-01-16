package mira.dbproject.carrental.service;

import java.util.List;
import mira.dbproject.carrental.domain.CarView;
import mira.dbproject.carrental.repository.dao.CarViewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarViewService {

  @Autowired
  CarViewDao carViewDao;

  public List<CarView> findAll(){
    return carViewDao.findAll();
  }

}
