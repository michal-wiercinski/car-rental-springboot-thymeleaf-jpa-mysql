package mira.dbproject.carrental.domain.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Table(name = "rental")
@Entity
public class Rental {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  private LocalDateTime dateFrom;
  private LocalDateTime dateTo;

  @ManyToOne
  @JoinColumn(name = "car_id")
  private Car car;

  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @ManyToOne
  @JoinColumn(name = "status_id")
  private RentalStatus rentalStatus;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getDateFrom() {
    return dateFrom;
  }

  public void setDateFrom(LocalDateTime dateFrom) {
    this.dateFrom = dateFrom;
  }

  public LocalDateTime getDateTo() {
    return dateTo;
  }

  public void setDateTo(LocalDateTime dateTo) {
    this.dateTo = dateTo;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public RentalStatus getRentalStatus() {
    return rentalStatus;
  }

  public void setRentalStatus(RentalStatus rentalStatus) {
    this.rentalStatus = rentalStatus;
  }
}
