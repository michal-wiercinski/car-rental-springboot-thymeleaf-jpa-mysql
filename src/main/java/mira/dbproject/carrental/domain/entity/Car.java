package mira.dbproject.carrental.domain.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import lombok.Data;

@NamedStoredProcedureQueries(
    @NamedStoredProcedureQuery(name = "Car.changeToAvailable",
        procedureName = "change_to_available_if_not_rented",
        parameters = {
            @StoredProcedureParameter(name = "p_pk_car", mode = ParameterMode.IN, type = Long.class),
            @StoredProcedureParameter(name = "p_pk_car_status", mode = ParameterMode.IN, type = String.class)
        }
    )
)
@Data
@Table(name = "car")
@Entity
public class Car implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "PK_car")
  private Long id;

  @Column(name = "registration_number")
  private String registrationNumber;

  @ManyToOne
  @JoinColumn(name = "FK_location")
  private Location location;

  @ManyToOne
  @JoinColumn(name = "FK_car_model")
  private CarModel carModel;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "FK_car_parameter")
  private CarParameter carParameter;

  @OneToMany(mappedBy = "car",
      cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  private List<Rental> rental;


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
