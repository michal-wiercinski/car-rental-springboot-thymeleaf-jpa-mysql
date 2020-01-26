package mira.dbproject.carrental.service.viewservice;

import java.util.List;
import java.util.Optional;
import mira.dbproject.carrental.domain.view.RentalView;
import mira.dbproject.carrental.repository.view.RentalViewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalViewService implements ICarViewService<RentalView> {

  @Autowired
  RentalViewDao rentalViewDao;

  @Override
  public List<RentalView> findAll() {
    return rentalViewDao.findAll();
  }

  @Override
  public List<RentalView> findAllAvailable() {
    return null;
  }

  @Override
  public Optional<RentalView> findById(Long id) {
    return Optional.empty();
  }
}
