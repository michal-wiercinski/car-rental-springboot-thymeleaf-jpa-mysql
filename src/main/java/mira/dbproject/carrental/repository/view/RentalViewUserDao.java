package mira.dbproject.carrental.repository.view;

import mira.dbproject.carrental.domain.view.RentalView;
import mira.dbproject.carrental.domain.view.RentalViewForUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalViewUserDao extends JpaRepository<RentalViewForUser, Long> {

}
