package mira.dbproject.carrental.service.viewservice;

import java.util.List;
import java.util.Optional;
import mira.dbproject.carrental.domain.view.RentalViewForAdmin;
import mira.dbproject.carrental.repository.view.RentalViewAdminDao;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class RentalViewAdminService implements IViewService<RentalViewForAdmin> {

  private final RentalViewAdminDao rentalViewAdminDao;

  public RentalViewAdminService(
      final RentalViewAdminDao rentalViewAdminDao) {
    this.rentalViewAdminDao = rentalViewAdminDao;
  }

  @Override
  public List<RentalViewForAdmin> findAll() {
    return null;
  }

  @Override
  public Optional<RentalViewForAdmin> findById(Long id) {
    return Optional.empty();
  }

  @Override
  public List<RentalViewForAdmin> findAllAndSortByParam(String sort, String direction) {
    if (!sort.isEmpty()) {
      if (!direction.isEmpty() && direction.equals(Direction.DESC.toString())) {
        return rentalViewAdminDao.findAll(Sort.by(sort).descending());
      }
      return rentalViewAdminDao.findAll(Sort.by(sort).ascending());
    }
    return rentalViewAdminDao.findAll();
  }
}
