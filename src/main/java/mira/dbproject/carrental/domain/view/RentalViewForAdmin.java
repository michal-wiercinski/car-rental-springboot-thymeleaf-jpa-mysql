package mira.dbproject.carrental.domain.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rental_view_for_admin")
public class RentalViewForAdmin extends RentalView {

  @Column(name = "user_email")
  private String userEmail;

  @Column(name = "registration_number")
  private String registrationNumber;

  @Column(name = "car_id")
  private Long carId;

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public void setRegistrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }

  public Long getCarId() {
    return carId;
  }

  public void setCarId(Long carId) {
    this.carId = carId;
  }
}
