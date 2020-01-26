package mira.dbproject.carrental.repository.dao;

import mira.dbproject.carrental.domain.entity.RentalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalDetailsDao extends JpaRepository<RentalDetails, Long> {

}
