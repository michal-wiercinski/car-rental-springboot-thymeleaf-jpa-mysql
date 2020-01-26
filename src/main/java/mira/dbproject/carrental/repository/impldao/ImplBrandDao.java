/*
package mira.dbproject.carrental.repository.impldao;

import java.sql.Types;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ImplBrandDao {

  private EntityManager entityManager;

  @Autowired
  public ImplBrandDao(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public String getBrandNameSql(Long id) {
    StoredProcedureQuery spq =
        entityManager.createNamedStoredProcedureQuery("Brand.NamedQuery_BrandName");
    spq.setParameter("in_id", id);
    spq.registerStoredProcedureParameter("brd_name", String.class, ParameterMode.OUT);
    spq.execute();

    String output = spq.;


    return output;

  }
}
*/
