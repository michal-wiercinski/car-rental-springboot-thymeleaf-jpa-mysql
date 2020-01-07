package mira.dbproject.carrental.domain.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "car_status")
public class CarStatus {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "status_code")
  @Id
  private String statusCode;

  @Column
  private String statusDescription;

  @OneToMany(mappedBy = "car_status")
  private List<Car> carList;

  public String getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }

  public String getStatusDescription() {
    return statusDescription;
  }

  public void setStatusDescription(String statusDescription) {
    this.statusDescription = statusDescription;
  }
}
