package mira.dbproject.carrental.service;

import java.util.List;
import java.util.Optional;
import mira.dbproject.carrental.domain.entity.Car;
import mira.dbproject.carrental.repository.dao.CarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService implements IGenericService<Car> {

  @Autowired
  CarDao carDao;

  @Override
  public List<Car> findAll() {
    return carDao.findAll();
  }

  @Override
  public Car save(Car entity) {
    return carDao.save(entity);
  }

  @Override
  public Optional<Car> findById(Long id) {
    return carDao.findById(id);
  }

  @Override
  public void delete(Car entity) {

  }

  @Override
  public void deleteById(Long id) {

  }

  @Override
  public Long count() {
    return null;
  }
}
