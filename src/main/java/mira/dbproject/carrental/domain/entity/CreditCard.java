package mira.dbproject.carrental.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "credit_card")
public class CreditCard {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "PK_credit_card")
  private Long id;

  @Column(name = "ccc_number")
  private String cccNumber;

  @Column(name = "ccc_expiration")
  private String cccExpiration;

  @Column(name = "ccc_cvv")
  private String cccCvv;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCccNumber() {
    return cccNumber;
  }

  public void setCccNumber(String cccNumber) {
    this.cccNumber = cccNumber;
  }

  public String getCccExpiration() {
    return cccExpiration;
  }

  public void setCccExpiration(String cccExpiration) {
    this.cccExpiration = cccExpiration;
  }

  public String getCccCvv() {
    return cccCvv;
  }

  public void setCccCvv(String cccCvv) {
    this.cccCvv = cccCvv;
  }
}
