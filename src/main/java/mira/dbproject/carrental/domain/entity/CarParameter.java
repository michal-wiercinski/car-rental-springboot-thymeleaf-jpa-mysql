package mira.dbproject.carrental.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;


@Data
@Table(name = "car_parameter")
@Entity
public class CarParameter {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_car_parameter")
  private Long id;

  @Column(name = "current_mileage")
  private Integer currentMileage;

  @Column(name = "engine_size")
  private Integer engineSize;

  @Column(name = "power")
  private Integer power;

  @Column(name = "year_of_prod")
  private Integer yearOfProd;

  @Column(name = "fuel_consumption")
  private Integer averageFuelConsumption;

  @Column(name = "daily_rate")
  private Integer dailyRate;

  @ManyToOne
  @JoinColumn(name = "body_type_id")
  private BodyType bodyType;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getEngineSize() {
    return engineSize;
  }

  public void setEngineSize(Integer engineSize) {
    this.engineSize = engineSize;
  }

  public Integer getPower() {
    return power;
  }

  public void setPower(Integer power) {
    this.power = power;
  }

  public Integer getYearOfProd() {
    return yearOfProd;
  }

  public void setYearOfProd(Integer yearOfProd) {
    this.yearOfProd = yearOfProd;
  }

  public Integer getDailyRate() {
    return dailyRate;
  }

  public void setDailyRate(Integer dailyRate) {
    this.dailyRate = dailyRate;
  }

  public Integer getAverageFuelConsumption() {
    return averageFuelConsumption;
  }

  public void setAverageFuelConsumption(Integer averageFuelConsumption) {
    this.averageFuelConsumption = averageFuelConsumption;
  }

  public Integer getCurrentMileage() {
    return currentMileage;
  }

  public void setCurrentMileage(Integer currentMileage) {
    this.currentMileage = currentMileage;
  }

  public BodyType getBodyType() {
    return bodyType;
  }

  public void setBodyType(BodyType bodyType) {
    this.bodyType = bodyType;
  }
}