package mira.dbproject.carrental.mapper;

import javax.transaction.Transactional;
import mira.dbproject.carrental.domain.dto.BrandDto;
import mira.dbproject.carrental.domain.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BrandMapper {

  @Autowired
  CarModelMapper carModelMapper;

  @Transactional
  public BrandDto mapEntityToDto(Brand manufacturer) {
    BrandDto brandDto = new BrandDto();

    brandDto.setId(manufacturer.getId());
    brandDto.setName(manufacturer.getName());

    return brandDto;
  }

}
