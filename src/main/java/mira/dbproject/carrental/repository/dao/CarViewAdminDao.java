package mira.dbproject.carrental.repository.dao;

import mira.dbproject.carrental.domain.view.CarView;
import mira.dbproject.carrental.domain.view.CarViewAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarViewAdminDao extends JpaRepository<CarViewAdmin, Long> {

}
