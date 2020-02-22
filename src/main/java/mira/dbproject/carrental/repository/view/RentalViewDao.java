package mira.dbproject.carrental.repository.view;

import java.util.List;
import mira.dbproject.carrental.domain.view.RentalView;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalViewDao extends JpaRepository<RentalView, Long> {


  List<RentalView> findByUserEmail(String email);

  List<RentalView> findByUserEmail(String email, Sort sort);

}
