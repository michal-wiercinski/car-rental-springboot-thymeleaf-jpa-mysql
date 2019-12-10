package mira.dbproject.carrental.domain.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({
    @NamedQuery(
        name = "BodyType.FindByName",
        query = "select t from BodyType t where t.typeName = :name"
    )
})
@Entity
public class BodyType implements Serializable {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  private String typeName;

  @OneToMany(mappedBy = "bodyType",
      cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
  private List<Car> vehicles;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

  public List<Car> getVehicles() {
    return vehicles;
  }

  public void setVehicles(List<Car> vehicles) {
    this.vehicles = vehicles;
  }
}
