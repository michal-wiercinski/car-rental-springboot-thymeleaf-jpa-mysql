package mira.dbproject.carrental.domain.view;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
@Data
@Entity
@Table(name = "rental_view")
public class RentalView {

  @Id
  @Column(name = "rental_id")
  private Long id;

  @Column(name = "rental_status")
  private String rentalStatus;

  @Column(name = "brand_name")
  private String brandName;

  @Column(name = "model_name")
  private String carModel;

  @Column(name = "daily_rate")
  private Integer dailyRate;

  @Column(name = "date_from")
  private Timestamp dateFrom;

  @Column(name = "date_end")
  private Timestamp dateEnd;

  @Column(name = "distance")
  private Integer distance;

  @Column(name = "rental_cost")
  private BigDecimal rentalCost;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRentalStatus() {
    return rentalStatus;
  }

  public void setRentalStatus(String rentalStatus) {
    this.rentalStatus = rentalStatus;
  }

  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public Integer getDailyRate() {
    return dailyRate;
  }

  public void setDailyRate(Integer dailyRate) {
    this.dailyRate = dailyRate;
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

  public String getCarModel() {
    return carModel;
  }

  public void setCarModel(String carModel) {
    this.carModel = carModel;
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
