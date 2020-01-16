package mira.dbproject.carrental.repository.dao;

import mira.dbproject.carrental.domain.view.CarViewUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarViewUserDao extends JpaRepository<CarViewUser, Long> {

}
