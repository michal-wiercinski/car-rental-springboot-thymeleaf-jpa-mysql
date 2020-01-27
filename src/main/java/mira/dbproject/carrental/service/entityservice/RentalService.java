package mira.dbproject.carrental.service.entityservice;

import java.util.List;
import java.util.Optional;
import mira.dbproject.carrental.domain.entity.Rental;
import mira.dbproject.carrental.domain.entity.RentalDetails;
import mira.dbproject.carrental.repository.dao.RentalDao;
import mira.dbproject.carrental.service.entityservice.IGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalService implements IGenericService<Rental> {

  private final RentalDao rentalDao;
  private final CarService carService;
  private final RentalDetailService rentalDetailService;

  public RentalService(final RentalDao rentalDao,
      final CarService carService,
      final RentalDetailService rentalDetailService) {
    this.rentalDao = rentalDao;
    this.carService = carService;
    this.rentalDetailService = rentalDetailService;
  }

  @Override
  public List<Rental> findAll() {
    return null;
  }

  @Override
  public Rental save(Rental entity) {
    return rentalDao.save(entity);
  }

  @Override
  public Optional<Rental> findById(Long id) {
    return rentalDao.findById(id);
  }

  @Override
  public void delete(Rental entity) {

  }

  @Override
  public void deleteById(Long id) {

  }


  public void createRental(Long id) {
    Rental rental = new Rental();
    rental.setCar(carService.findById(id).get());
    rental.setRentalDetails(rentalDetailService.save(new RentalDetails()));
    save(rental);
  }
}
