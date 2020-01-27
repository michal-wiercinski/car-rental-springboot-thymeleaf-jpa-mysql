package mira.dbproject.carrental.mapper;

import javax.transaction.Transactional;
import mira.dbproject.carrental.domain.dto.LocationDto;
import mira.dbproject.carrental.domain.entity.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {

  @Transactional
  public LocationDto mapEntityToDto(Location location) {
    LocationDto locationDto = new LocationDto();

    locationDto.setId(location.getId());
    locationDto.setName(location.getName());

    return locationDto;
  }
}
