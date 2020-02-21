package mira.dbproject.carrental.domain.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import lombok.Data;

@NamedStoredProcedureQueries(
    @NamedStoredProcedureQuery(name = "RentalDetail.UpdateEndTime",
        procedureName = "update_end_date_by_pk",
        parameters = {
            @StoredProcedureParameter(name = "p_pk_rental_detail", mode = ParameterMode.IN, type = Long.class)
        }
    )
)
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
  private BigDecimal rentalCost;

  @Column(name = "distance")
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

  public BigDecimal getRentalCost() {
    return rentalCost;
  }

  public void setRentalCost(BigDecimal rentalCost) {
    this.rentalCost = rentalCost;
  }
}
