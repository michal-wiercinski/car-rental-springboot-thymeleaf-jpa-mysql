package mira.dbproject.carrental.service;

import javax.transaction.Transactional;
import mira.dbproject.carrental.domain.entity.CarParameter;
import mira.dbproject.carrental.repository.dao.CarParameterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarParameterService {

  @Autowired
  CarParameterDao carParameterDao;

  @Transactional
  public CarParameter save(CarParameter carParameter){
    return carParameterDao.save(carParameter);
  }

}
