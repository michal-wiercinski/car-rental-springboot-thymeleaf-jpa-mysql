package mira.dbproject.carrental.service.entityservice;

import java.util.List;
import java.util.Optional;
import mira.dbproject.carrental.domain.entity.CarModel;
import mira.dbproject.carrental.repository.entity.CarModelDao;
import org.springframework.stereotype.Service;

@Service
public class CarModelService implements IGenericService<CarModel> {

  private final CarModelDao carModelDao;

  public CarModelService(final CarModelDao carModelDao) {
    this.carModelDao = carModelDao;
  }

  @Override
  public List<CarModel> findAll() {
    return carModelDao.findAll();
  }

  @Override
  public CarModel save(CarModel entity) {
    return null;
  }

  @Override
  public Optional<CarModel> findById(Long id) {
    return carModelDao.findById(id);
  }

  @Override
  public void delete(CarModel entity) {

  }

  @Override
  public void deleteById(Long id) {

  }
}