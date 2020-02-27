package mira.dbproject.carrental.repository.entity;

import mira.dbproject.carrental.domain.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalDao extends JpaRepository<Rental, Long> {

  @Procedure(procedureName = "set_cancel_rental_status_by_pk")
  void updateStatusById(@Param("p_pk_rental") Long id);

}
