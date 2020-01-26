package mira.dbproject.carrental.repository.dao;

import mira.dbproject.carrental.domain.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends JpaRepository<Address, Long> {

  @Procedure(procedureName = "create_address")
  void createAddress(@Param("p_city") String city, @Param("p_street") String street,
      @Param("p_house_number") String house_number, @Param("p_flat_number") String flatNumber,
      @Param("p_zip_code") String zipCode);

}
