package mira.dbproject.carrental.service.entityservice;

import java.util.List;
import java.util.Optional;
import mira.dbproject.carrental.domain.dto.CarDto;
import mira.dbproject.carrental.domain.entity.Car;
import mira.dbproject.carrental.domain.entity.CarParameter;
import mira.dbproject.carrental.mapper.CarMapper;
import mira.dbproject.carrental.repository.dao.CarDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CarService implements IGenericService<Car> {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  private final CarDao carDao;
  private final CarMapper carMapper;
  private final CarParameterService carParameterService;

  public CarService(final CarDao carDao, final CarMapper carMapper,
      final CarParameterService carParameterService) {
    this.carDao = carDao;
    this.carMapper = carMapper;
    this.carParameterService = carParameterService;
  }

  public void changeToAvailable(Long carId, String carStatus){
    carDao.changeToAvailable(carId, carStatus);
  }

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
    carDao.deleteById(id);
  }


  public Car createNewCar(CarDto carDto) {
    Car car = carMapper.mapNewCarToEntity(carDto);
    CarParameter carParameter = carParameterService.createNewParameter(carDto);
    car.setCarParameter(carParameter);
    logger.debug("carDto has been mapped to entity");
    save(car);
    logger.info("New car for id {} has been created ", car.getId());
    return car;
  }
}
