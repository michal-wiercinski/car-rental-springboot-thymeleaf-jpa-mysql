package mira.dbproject.carrental.mapper;

import javax.transaction.Transactional;
import mira.dbproject.carrental.domain.dto.BodyTypeDto;
import mira.dbproject.carrental.domain.entity.BodyType;
import org.springframework.stereotype.Component;

@Component
public class BodyTypeMapper {

  @Transactional
  public BodyTypeDto mapEntityToDto(BodyType bodyType) {
    BodyTypeDto bodyTypeDto = new BodyTypeDto();

    bodyTypeDto.setId(bodyType.getId());
    bodyTypeDto.setTypeName(bodyType.getTypeName());

    return bodyTypeDto;
  }
}