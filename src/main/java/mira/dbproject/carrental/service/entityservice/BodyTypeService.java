package mira.dbproject.carrental.service.entityservice;

import java.util.List;
import java.util.Optional;
import mira.dbproject.carrental.domain.entity.BodyType;
import mira.dbproject.carrental.repository.dao.BodyTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BodyTypeService implements IGenericService<BodyType> {

  @Autowired
  BodyTypeDao bodyTypeDao;

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
