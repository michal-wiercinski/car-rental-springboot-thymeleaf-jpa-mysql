package mira.dbproject.carrental.mapper;

import javax.transaction.Transactional;
import mira.dbproject.carrental.domain.dto.CarDto;
import mira.dbproject.carrental.domain.entity.Car;
import mira.dbproject.carrental.service.entityservice.BodyTypeService;
import mira.dbproject.carrental.service.entityservice.CarModelService;
import mira.dbproject.carrental.service.entityservice.LocationService;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

  private final CarModelService carModelService;
  private final LocationService locationService;
  private final BodyTypeService bodyTypeService;

  public CarMapper(final CarModelService carModelService,
      final LocationService locationService,
      final BodyTypeService bodyTypeService) {
    this.carModelService = carModelService;
    this.locationService = locationService;
    this.bodyTypeService = bodyTypeService;
  }

  @Transactional
  public Car mapNewCarToEntity(CarDto carDto) {
    Car car = new Car();
    car.setRegistrationNumber(carDto.getRegistrationNumber());
    car.setCarModel(carModelService.findById(carDto.getCarModelDtoId()).get());
    car.setLocation(locationService.findById(carDto.getLocationDtoId()).get());

    return car;
  }
}
