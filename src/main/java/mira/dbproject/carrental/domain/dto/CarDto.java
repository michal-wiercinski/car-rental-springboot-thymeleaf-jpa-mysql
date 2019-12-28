package mira.dbproject.carrental.domain.dto;

public class CarDto {

  private Long id;

  private String registrationNumber;
  private Integer dailyRate;
  private Boolean isRent = false;
  private LocationDto locationDto;
  private CarModelDto carModelDto;
  private BodyTypeDto bodyTypeDto;
  private CarParameterDto carParameterDto;

}
