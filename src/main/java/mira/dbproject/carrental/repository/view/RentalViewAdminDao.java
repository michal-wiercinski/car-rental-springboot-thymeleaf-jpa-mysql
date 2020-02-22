package mira.dbproject.carrental.repository.view;

import mira.dbproject.carrental.domain.view.RentalViewForAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalViewAdminDao extends JpaRepository<RentalViewForAdmin, Long> {

}
