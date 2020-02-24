package mira.dbproject.carrental.service.entityservice;

import java.util.List;
import java.util.Optional;
import mira.dbproject.carrental.domain.entity.RentalDetails;
import mira.dbproject.carrental.repository.dao.RentalDetailsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalDetailService implements IGenericService<RentalDetails> {

  private final RentalDetailsDao rentalDetailsDao;

  public RentalDetailService(
      final RentalDetailsDao rentalDetailsDao) {
    this.rentalDetailsDao = rentalDetailsDao;
  }

  public void updateDate(Long id) {
    rentalDetailsDao.updateEndDateById(id);
  }

  @Override
  public List<RentalDetails> findAll() {
    return null;
  }

  @Override
  public RentalDetails save(RentalDetails entity) {
    return rentalDetailsDao.save(entity);
  }

  @Override
  public Optional<RentalDetails> findById(Long id) {
    return Optional.empty();
  }

  @Override
  public void delete(RentalDetails entity) {

  }

  @Override
  public void deleteById(Long id) {

  }
}
