package mira.dbproject.carrental.domain.dto;

import javax.validation.constraints.NotNull;

public class CarDto {

  private Long id;

  private String registrationNumber;
  private Integer dailyRate;
  private Boolean isRent = false;
  private Long bodyTypeDtoId;
  private Long LocationDtoId;
  private Long carModelDtoId;
  private Integer currentMileage;
  private Integer engineSize;
  private Integer yearOfProd;
  private Integer averageFuelConsumption;
  private Integer power;

  public CarDto() {
  }

  public CarDto(String registrationNumber, Integer dailyRate, Boolean isRent,
      Long bodyTypeDtoId, Long locationDtoId, Long carModelDtoId, Integer currentMileage,
      Integer engineSize, Integer yearOfProd, Integer averageFuelConsumption) {

    this.registrationNumber = registrationNumber;
    this.dailyRate = dailyRate;
    this.isRent = isRent;
    this.bodyTypeDtoId = bodyTypeDtoId;
    LocationDtoId = locationDtoId;
    this.carModelDtoId = carModelDtoId;
    this.currentMileage = currentMileage;
    this.engineSize = engineSize;
    this.yearOfProd = yearOfProd;
    this.averageFuelConsumption = averageFuelConsumption;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public void setRegistrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }

  public Integer getDailyRate() {
    return dailyRate;
  }

  public void setDailyRate(Integer dailyRate) {
    this.dailyRate = dailyRate;
  }

  public Boolean getRent() {
    return isRent;
  }

  public void setRent(Boolean rent) {
    isRent = rent;
  }

  public Long getBodyTypeDtoId() {
    return bodyTypeDtoId;
  }

  public void setBodyTypeDtoId(Long bodyTypeDtoId) {
    this.bodyTypeDtoId = bodyTypeDtoId;
  }

  public Long getLocationDtoId() {
    return LocationDtoId;
  }

  public void setLocationDtoId(Long locationDtoId) {
    LocationDtoId = locationDtoId;
  }

  public Long getCarModelDtoId() {
    return carModelDtoId;
  }

  public void setCarModelDtoId(Long carModelDtoId) {
    this.carModelDtoId = carModelDtoId;
  }

  public Integer getCurrentMileage() {
    return currentMileage;
  }

  public void setCurrentMileage(Integer currentMileage) {
    this.currentMileage = currentMileage;
  }

  public Integer getEngineSize() {
    return engineSize;
  }

  public void setEngineSize(Integer engineSize) {
    this.engineSize = engineSize;
  }

  public Integer getYearOfProd() {
    return yearOfProd;
  }

  public void setYearOfProd(Integer yearOfProd) {
    this.yearOfProd = yearOfProd;
  }

  public Integer getAverageFuelConsumption() {
    return averageFuelConsumption;
  }

  public void setAverageFuelConsumption(Integer averageFuelConsumption) {
    this.averageFuelConsumption = averageFuelConsumption;
  }
}
