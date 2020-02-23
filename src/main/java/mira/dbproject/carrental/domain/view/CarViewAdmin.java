package mira.dbproject.carrental.domain.view;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.context.annotation.Scope;

@Scope("request")
@Entity
@Table(name = "details_fleet")
public class CarViewAdmin extends CarView {

  @Column(name = "income")
  private BigDecimal income;

  @Column(name = "current_mileage")
  private Integer currentMileage;

  public BigDecimal getIncome() {
    return income;
  }

  public void setIncome(BigDecimal income) {
    this.income = income;
  }

  public Integer getCurrentMileage() {
    return currentMileage;
  }

  public void setCurrentMileage(Integer currentMileage) {
    this.currentMileage = currentMileage;
  }
}