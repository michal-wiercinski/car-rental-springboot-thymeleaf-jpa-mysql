package mira.dbproject.carrental.mapper;

import static org.junit.jupiter.api.Assertions.*;

import javax.validation.constraints.AssertTrue;
import mira.dbproject.carrental.domain.dto.CarDto;
import mira.dbproject.carrental.domain.entity.Car;
import mira.dbproject.carrental.service.CarService;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.AssertionErrors;

class CarMapperTest {

/*
  @Test
  public void checkIfSave() {
    CarDto carDto = new CarDto("aaaa", 30, false,
        1L,
        1L,
        1L,
        1,
        1111,
        2019,
        10
    );

    CarMapper carMapper = new CarMapper();

    Car car = new Car();

    CarService carService = new CarService();
    int startSize = carService.findAll().size();

    carMapper.mapNewCarToEntity(carDto);

    carService.save(car);

    int expectedValue = carService.findAll().size();

    Assertions.assertNotEquals(startSize, expectedValue);



  }
*/

}