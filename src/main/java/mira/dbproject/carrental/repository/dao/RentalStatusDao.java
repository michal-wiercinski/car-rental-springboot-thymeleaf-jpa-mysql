package mira.dbproject.carrental.repository.dao;

import mira.dbproject.carrental.domain.entity.RentalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface RentalStatusDao  extends JpaRepository<RentalStatus, Long> {

}
