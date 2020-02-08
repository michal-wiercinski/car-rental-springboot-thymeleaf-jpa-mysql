package mira.dbproject.carrental.domain.entity;

import javax.persistence.Column;
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
@Table(name = "user_details")
@Entity
public class UserDetail {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "PK_user_details")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "FK_address")
  private Address address;

  @OneToOne
  @JoinColumn(name = "FK_credit_card")
  private CreditCard creditCard;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public CreditCard getCreditCard() {
    return creditCard;
  }

  public void setCreditCard(CreditCard creditCard) {
    this.creditCard = creditCard;
  }
}
