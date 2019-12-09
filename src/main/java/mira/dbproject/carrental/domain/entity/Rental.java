package mira.dbproject.carrental.domain.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Rental {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  private LocalDateTime dateFrom;
  private LocalDateTime dateTo;

  @OneToOne
  @JoinColumn(name = "vehicle_id")
  private Vehicle vehicle;

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

  public Vehicle getVehicle() {
    return vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
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
