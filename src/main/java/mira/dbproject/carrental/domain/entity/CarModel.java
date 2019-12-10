package mira.dbproject.carrental.domain.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({
    @NamedQuery(
        name = "CarModel.FindByName",
        query = "select m from CarModel m where m.name = :name"
    ),
    @NamedQuery(
        name = "CarModel.FindByManufacturerName",
        query = "select m from CarModel m where m.manufacturer = :manufacturerId"
    )
})
@Entity
public class CarModel implements Serializable {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  private String name;

  @ManyToOne
  @JoinColumn(name = "manufacturer_id")
  private Manufacturer manufacturer;

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

  public Manufacturer getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(Manufacturer manufacturer) {
    this.manufacturer = manufacturer;
  }

  public List<Car> getVehicles() {
    return vehicles;
  }

  public void setVehicles(List<Car> vehicles) {
    this.vehicles = vehicles;
  }
}
