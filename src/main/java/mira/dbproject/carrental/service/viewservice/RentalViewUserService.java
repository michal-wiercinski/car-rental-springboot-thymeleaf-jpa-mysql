package mira.dbproject.carrental.service.viewservice;

import java.util.List;
import java.util.Optional;
import mira.dbproject.carrental.domain.view.RentalView;
import mira.dbproject.carrental.domain.view.RentalViewForUser;
import mira.dbproject.carrental.repository.view.RentalViewUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class RentalViewUserService implements IViewService<RentalViewForUser> {

  @Autowired
  RentalViewUserDao rentalViewDao;

  @Override
  public List<RentalViewForUser> findAll() {
    return rentalViewDao.findAll();
  }

  @Override
  public Optional<RentalViewForUser> findById(Long id) {
    return Optional.empty();
  }

  @Override
  public List<RentalViewForUser> findAllAndSortByParam(String sort, String direction) {
    if (!sort.isEmpty() ) {
      if (!direction.isEmpty() && direction.equals(Direction.DESC.toString())) {
        return rentalViewDao.findAll(Sort.by(sort).descending());
      }
      return rentalViewDao.findAll(Sort.by(sort).ascending());
    }
    return rentalViewDao.findAll();
  }

}
