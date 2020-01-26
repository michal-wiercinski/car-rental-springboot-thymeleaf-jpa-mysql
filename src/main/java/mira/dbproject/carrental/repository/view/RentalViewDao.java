package mira.dbproject.carrental.repository.view;

import mira.dbproject.carrental.domain.view.RentalView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalViewDao extends JpaRepository<RentalView, Long> {

}
