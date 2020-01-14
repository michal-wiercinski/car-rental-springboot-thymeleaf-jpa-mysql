package mira.dbproject.carrental.service;

import java.util.List;
import java.util.Optional;
import mira.dbproject.carrental.domain.entity.CarStatus;
import mira.dbproject.carrental.repository.dao.CarStatusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarStatusService {

  @Autowired
  CarStatusDao carStatusDao;

  public Optional<CarStatus> findById(String id){
    return carStatusDao.findById(id);
  }

  public List<CarStatus> findAll(){
    return carStatusDao.findAll();
  }

}
