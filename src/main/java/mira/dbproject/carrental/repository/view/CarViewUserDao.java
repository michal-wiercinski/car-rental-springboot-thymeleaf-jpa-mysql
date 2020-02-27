package mira.dbproject.carrental.repository.view;

import java.util.List;
import mira.dbproject.carrental.domain.view.CarViewUser;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarViewUserDao extends JpaRepository<CarViewUser, Long> {

  List<CarViewUser> findCarViewUserByCarStatusIsLike(String status);

  List<CarViewUser> findCarViewUserByCarStatusIsLike(String status, Sort sort);
}
