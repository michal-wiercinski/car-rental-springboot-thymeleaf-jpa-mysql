package mira.dbproject.carrental.mapper;

import javax.transaction.Transactional;
import mira.dbproject.carrental.domain.dto.CarDto;
import mira.dbproject.carrental.domain.entity.Car;
import mira.dbproject.carrental.domain.entity.CarParameter;
import mira.dbproject.carrental.service.CarModelService;
import mira.dbproject.carrental.service.CarParameterService;
import mira.dbproject.carrental.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

  @Autowired
  CarModelService carModelService;

  @Autowired
  LocationService locationService;

  @Autowired
  CarParameterService carParameterService;

  @Transactional
  public Car mapNewCarToEntity(CarDto carDto) {
    Car car = new Car();

    car.setRegistrationNumber(carDto.getRegistrationNumber());
    car.setDailyRate(carDto.getDailyRate());
    car.setCarModel(carModelService.findById(carDto.getCarModelDto().getId()).get());
    car.setLocation(locationService.findById(carDto.getLocationDto().getId()).get());

    CarParameter carParameter = new CarParameter();

    carParameter.setYearOfProd(carDto.getYearOfProd());
    carParameter.setAverageFuelConsumption(carDto.getAverageFuelConsumption());
    carParameter.setCurrentMileage(carDto.getCurrentMileage());
    carParameter.setEngineSize(carDto.getEngineSize());
    carParameterService.save(carParameter);
    car.setCarParameter(carParameter);

    return car;
  }

}
