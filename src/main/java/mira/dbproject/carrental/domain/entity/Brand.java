package mira.dbproject.carrental.domain.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@NamedQueries({
    @NamedQuery(
        name = "Brand.FindByName",
        query = "select m from Brand m where m.name = :name"
    )
})
@Data
@Table(name = "brand")
@Entity
public class Brand implements Serializable {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "PK_brand")
  private Long id;

  @Column(name = "brand_name")
  private String name;

  @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
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
