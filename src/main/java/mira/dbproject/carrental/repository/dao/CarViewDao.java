package mira.dbproject.carrental.repository.dao;

import mira.dbproject.carrental.domain.CarView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarViewDao extends JpaRepository<CarView, Long> {

}
