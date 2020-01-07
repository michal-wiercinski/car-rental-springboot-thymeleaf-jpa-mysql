package mira.dbproject.carrental.domain.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@NamedQueries({
    @NamedQuery(
        name = "CarModel.FindByName",
        query = "select m from CarModel m where m.name = :name"
    ),
    @NamedQuery(
        name = "CarModel.FindByManufacturerName",
        query = "select m from CarModel m where m.brand = :brandId"
    )
})
@Data
@Table(name = "car_model")
@Entity
public class CarModel implements Serializable {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id_car_model")
  private Long id;

  @Column(name = "car_model_name")
  private String name;

  @ManyToOne
  @JoinColumn(name = "brand_id")
  private Brand brand;

  @OneToMany(mappedBy = "carModel",
      cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  private List<Car> vehicles;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Brand getBrand() {
    return brand;
  }

  public void setBrand(Brand brand) {
    this.brand = brand;
  }

  public List<Car> getVehicles() {
    return vehicles;
  }

  public void setVehicles(List<Car> vehicles) {
    this.vehicles = vehicles;
  }
}
