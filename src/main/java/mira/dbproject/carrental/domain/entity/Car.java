package mira.dbproject.carrental.domain.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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

  @OneToOne
  @JoinColumn(name = "rental_id")
  private Rental rental;

  @ManyToOne
  @JoinColumn(name = "car_parameter")
  private CarParameter carParameter;
  
  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public void setRegistrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }

}
