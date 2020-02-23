package mira.dbproject.carrental.service.entityservice;

import java.util.List;
import java.util.Optional;
import mira.dbproject.carrental.domain.entity.CarStatus;
import mira.dbproject.carrental.repository.dao.CarStatusDao;
import org.springframework.stereotype.Service;

@Service
public class CarStatusService {

  private final CarStatusDao carStatusDao;

  public CarStatusService(final CarStatusDao carStatusDao) {
    this.carStatusDao = carStatusDao;
  }

  public Optional<CarStatus> findById(String id) {
    return carStatusDao.findById(id);
  }

  public List<CarStatus> findAll() {
    return carStatusDao.findAll();
  }
}