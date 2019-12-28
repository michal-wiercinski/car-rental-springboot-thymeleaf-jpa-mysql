package mira.dbproject.carrental.mapper;

import javax.transaction.Transactional;
import mira.dbproject.carrental.domain.dto.CarModelDto;
import mira.dbproject.carrental.domain.entity.CarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarModelMapper {

  @Autowired
  BrandMapper brandMapper;

  @Transactional
  public CarModelDto mapEntityToDto(CarModel carModel) {
    CarModelDto carModelDto = new CarModelDto();

    carModelDto.setId(carModel.getId());
    carModelDto.setName(carModel.getName());
    carModelDto.setBrandDto(brandMapper.mapEntityToDto(carModel.getBrand()));

    return carModelDto;
  }
}