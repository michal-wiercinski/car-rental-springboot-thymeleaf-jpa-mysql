package mira.dbproject.carrental.mapper;

import javax.transaction.Transactional;
import mira.dbproject.carrental.domain.dto.CarDto;
import mira.dbproject.carrental.domain.entity.Car;
import mira.dbproject.carrental.service.BodyTypeService;
import mira.dbproject.carrental.service.CarModelService;
import mira.dbproject.carrental.service.CarParameterService;
import mira.dbproject.carrental.service.CarStatusService;
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
  BodyTypeService bodyTypeService;
  @Autowired
  CarParameterService carParameterService;

  @Autowired
  CarStatusService carStatusService;

  @Transactional
  public Car mapNewCarToEntity(CarDto carDto) {
    Car car = new Car();

    car.setRegistrationNumber(carDto.getRegistrationNumber());
    car.setBodyType(bodyTypeService.findById(carDto.getBodyTypeDtoId()).get());
    car.setCarModel(carModelService.findById(carDto.getCarModelDtoId()).get());
    car.setLocation(locationService.findById(carDto.getLocationDtoId()).get());
    car.setCarStatus(carStatusService.findById(carDto.getCarStatus()).get());
    
    return car;
  }

}
