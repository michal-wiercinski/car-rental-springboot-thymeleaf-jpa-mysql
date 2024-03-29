package mira.dbproject.carrental.security.repository;

import mira.dbproject.carrental.domain.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailDao extends JpaRepository<UserDetail, Long> {

}
