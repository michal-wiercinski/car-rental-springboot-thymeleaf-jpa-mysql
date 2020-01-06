package mira.dbproject.carrental.service;

import java.util.List;
import java.util.Optional;
import mira.dbproject.carrental.domain.entity.Location;
import mira.dbproject.carrental.repository.dao.LocationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService implements IGenericService<Location> {

  @Autowired
  LocationDao locationDao;

  @Override
  public List<Location> findAll() {
    return locationDao.findAll();
  }

  @Override
  public Location save(Location entity) {
    return null;
  }

  @Override
  public Optional<Location> findById(Long id) {
    return locationDao.findById(id);
  }

  @Override
  public void delete(Location entity) {

  }

  @Override
  public void deleteById(Long id) {

  }
}
