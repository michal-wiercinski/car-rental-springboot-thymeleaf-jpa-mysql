package mira.dbproject.carrental.domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "Details fleet")
public class CarView {

  @Column(name = "Car ID")
  private Long id;

  @Column(name = "Income")
  private BigDecimal income;

  @Column(name = "Brand")
  private String brandName;

  @Column(name = "Car model")
  private String carModelName;

  @Column(name = "Body type")
  private String bodyType;

  @Column(name = "Engine power(MP)")
  private Integer enginePower;

  @Column(name = "Engine size")
  private Integer engineSize;

  @Column(name = "Production year")
  private Integer prodYear;

  @Column(name = "Current mileage")
  private Integer currentMileage;

  @Column(name = "Daily rate")
  private Integer dailyRate;

  @Column(name = "Status")
  private String car_status;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public BigDecimal getIncome() {
    return income;
  }

  public void setIncome(BigDecimal income) {
    this.income = income;
  }

  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public String getCarModelName() {
    return carModelName;
  }

  public void setCarModelName(String carModelName) {
    this.carModelName = carModelName;
  }

  public String getBodyType() {
    return bodyType;
  }

  public void setBodyType(String bodyType) {
    this.bodyType = bodyType;
  }

  public Integer getEnginePower() {
    return enginePower;
  }

  public void setEnginePower(Integer enginePower) {
    this.enginePower = enginePower;
  }

  public Integer getEngineSize() {
    return engineSize;
  }

  public void setEngineSize(Integer engineSize) {
    this.engineSize = engineSize;
  }

  public Integer getProdYear() {
    return prodYear;
  }

  public void setProdYear(Integer prodYear) {
    this.prodYear = prodYear;
  }

  public Integer getCurrentMileage() {
    return currentMileage;
  }

  public void setCurrentMileage(Integer currentMileage) {
    this.currentMileage = currentMileage;
  }

  public Integer getDailyRate() {
    return dailyRate;
  }

  public void setDailyRate(Integer dailyRate) {
    this.dailyRate = dailyRate;
  }

  public String getCar_status() {
    return car_status;
  }

  public void setCar_status(String car_status) {
    this.car_status = car_status;
  }
}
