package mira.dbproject.carrental.repository.entity;

import mira.dbproject.carrental.domain.entity.RentalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalStatusDao  extends JpaRepository<RentalStatus, Long> {

}
