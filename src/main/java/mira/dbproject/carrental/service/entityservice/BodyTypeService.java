package mira.dbproject.carrental.service.entityservice;

import java.util.List;
import java.util.Optional;
import mira.dbproject.carrental.domain.entity.BodyType;
import mira.dbproject.carrental.repository.entity.BodyTypeDao;
import org.springframework.stereotype.Service;

@Service
public class BodyTypeService implements IGenericService<BodyType> {

  private final BodyTypeDao bodyTypeDao;

  public BodyTypeService(final BodyTypeDao bodyTypeDao) {
    this.bodyTypeDao = bodyTypeDao;
  }

  @Override
  public List<BodyType> findAll() {
    return bodyTypeDao.findAll();
  }

  @Override
  public BodyType save(BodyType entity) {
    return null;
  }

  @Override
  public Optional<BodyType> findById(Long id) {
    return bodyTypeDao.findById(id);
  }

  @Override
  public void delete(BodyType entity) {

  }

  @Override
  public void deleteById(Long id) {

  }
}
