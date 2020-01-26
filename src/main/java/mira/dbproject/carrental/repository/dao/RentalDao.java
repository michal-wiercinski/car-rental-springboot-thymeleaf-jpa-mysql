package mira.dbproject.carrental.repository.dao;

import mira.dbproject.carrental.domain.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalDao extends JpaRepository<Rental, Long> {

}
