package mira.dbproject.carrental.security.repository;

import java.util.Optional;
import mira.dbproject.carrental.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

  Optional<User> findByUsername(String username);
}
