package mira.dbproject.carrental.repository.view;

import mira.dbproject.carrental.domain.view.CarViewAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarViewAdminDao extends JpaRepository<CarViewAdmin, Long> {

}
