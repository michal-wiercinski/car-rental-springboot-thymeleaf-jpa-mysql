package mira.dbproject.carrental.service.entityservice;

import java.util.Optional;
import mira.dbproject.carrental.domain.entity.RentalStatus;
import mira.dbproject.carrental.repository.dao.RentalStatusDao;
import org.springframework.stereotype.Service;

@Service
public class RentalStatusService {

  private final RentalStatusDao rentalStatusDao;

  public RentalStatusService(final RentalStatusDao rentalStatusDao) {
    this.rentalStatusDao = rentalStatusDao;
  }

  public Optional<RentalStatus> findById(Long id) {
    return rentalStatusDao.findById(id);
  }
}
