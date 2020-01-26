package mira.dbproject.carrental.service.entityservice;

import java.util.List;
import java.util.Optional;
import mira.dbproject.carrental.domain.entity.RentalStatus;
import mira.dbproject.carrental.repository.dao.RentalStatusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalStatusService implements IGenericService<RentalStatus> {

  @Autowired
  RentalStatusDao rentalStatusDao;

  @Override
  public List<RentalStatus> findAll() {
    return null;
  }

  @Override
  public RentalStatus save(RentalStatus entity) {
    return null;
  }

  @Override
  public Optional<RentalStatus> findById(Long id) {
    return rentalStatusDao.findById(id);
  }

  @Override
  public void delete(RentalStatus entity) {

  }

  @Override
  public void deleteById(Long id) {

  }
}
