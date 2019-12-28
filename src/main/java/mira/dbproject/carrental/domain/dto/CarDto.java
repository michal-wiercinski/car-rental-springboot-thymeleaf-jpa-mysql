package mira.dbproject.carrental.domain.dto;

public class CarDto {

  private Long id;

  private String registrationNumber;
  private Integer dailyRate;
  private Boolean isRent = false;
  private LocationDto locationDto;
  private CarModelDto carModelDto;
  private BodyTypeDto bodyTypeDto;
  private Integer currentMileage;
  private Integer engineSize;
  private Integer yearOfProd;
  private Integer averageFuelConsumption;

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

  public LocationDto getLocationDto() {
    return locationDto;
  }

  public void setLocationDto(LocationDto locationDto) {
    this.locationDto = locationDto;
  }

  public CarModelDto getCarModelDto() {
    return carModelDto;
  }

  public void setCarModelDto(CarModelDto carModelDto) {
    this.carModelDto = carModelDto;
  }

  public BodyTypeDto getBodyTypeDto() {
    return bodyTypeDto;
  }

  public void setBodyTypeDto(BodyTypeDto bodyTypeDto) {
    this.bodyTypeDto = bodyTypeDto;
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
