package mira.dbproject.carrental.domain.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Table(name = "car")
@Entity
public class Car implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String registrationNumber;
  private Integer dailyRate;
  private Boolean isRent = false;

  @ManyToOne
  @JoinColumn(name = "location_id")
  private Location location;

  @ManyToOne
  @JoinColumn(name = "car_model_id")
  private CarModel carModel;

  @ManyToOne
  @JoinColumn(name = "body_type_id")
  private BodyType bodyType;

  @OneToMany(mappedBy = "car",
      cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  private List<Rental> rental;

  @OneToOne
  @JoinColumn(name = "car_parameter_id")
  private CarParameter carParameter;
  
  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public void setRegistrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public CarModel getCarModel() {
    return carModel;
  }

  public void setCarModel(CarModel carModel) {
    this.carModel = carModel;
  }

  public BodyType getBodyType() {
    return bodyType;
  }

  public void setBodyType(BodyType bodyType) {
    this.bodyType = bodyType;
  }

  public List<Rental> getRental() {
    return rental;
  }

  public void setRental(List<Rental> rental) {
    this.rental = rental;
  }

  public CarParameter getCarParameter() {
    return carParameter;
  }

  public void setCarParameter(CarParameter carParameter) {
    this.carParameter = carParameter;
  }
}
