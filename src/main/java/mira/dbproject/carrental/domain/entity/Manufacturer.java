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
import javax.persistence.OneToOne;

@NamedQueries({
    @NamedQuery(
        name = "Manufacturer.FindByName",
        query = "select m from Manufacturer m where m.name = :name"
    )
})
@Entity
public class Manufacturer implements Serializable {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  private String name;

  @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL)
  private List<CarModel> models;

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

  public List<CarModel> getModels() {
    return models;
  }

  public void setModels(List<CarModel> models) {
    this.models = models;
  }
}
