package mira.dbproject.carrental.repository.dao;

import mira.dbproject.carrental.domain.entity.Brand;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandDao extends GenericDao<Brand> {

  @Procedure(procedureName = "get_brand_name", outputParameterName = "brd_name")
  String getBrandNameById(@Param("in_id") Long id);
}