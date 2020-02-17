package mira.dbproject.carrental.repository.dao;

import mira.dbproject.carrental.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {


}
