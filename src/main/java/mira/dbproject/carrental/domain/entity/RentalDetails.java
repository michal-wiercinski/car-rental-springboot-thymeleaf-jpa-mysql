package mira.dbproject.carrental.domain.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Table(name = "rental_details")
@Entity
public class RentalDetails {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "PK_rental_details")
  private Long id;

  @Column(name = "date_from")
  private Timestamp dateFrom;

  @Column(name = "date_end")
  private Timestamp dateEnd;

  @Column(name = "rental_cost")
  private Integer distance;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Timestamp getDateFrom() {
    return dateFrom;
  }

  public void setDateFrom(Timestamp dateFrom) {
    this.dateFrom = dateFrom;
  }

  public Timestamp getDateEnd() {
    return dateEnd;
  }

  public void setDateEnd(Timestamp dateEnd) {
    this.dateEnd = dateEnd;
  }

  public Integer getDistance() {
    return distance;
  }

  public void setDistance(Integer distance) {
    this.distance = distance;
  }

}
