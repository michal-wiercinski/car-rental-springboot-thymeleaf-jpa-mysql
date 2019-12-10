package mira.dbproject.carrental.service;

import javax.annotation.PostConstruct;
import mira.dbproject.carrental.domain.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrepareService {

  @Autowired
  CarService carService;

  @PostConstruct
  public void prepareSomeCar(){
    Car car = new Car();
    car.setRegistrationNumber("asdasdwqd");
    carService.save(car);

  }
}
