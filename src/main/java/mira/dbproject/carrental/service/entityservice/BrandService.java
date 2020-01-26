package mira.dbproject.carrental.service.entityservice;

import java.util.List;
import java.util.Optional;
import mira.dbproject.carrental.domain.entity.Brand;
import mira.dbproject.carrental.repository.dao.BrandDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService implements IGenericService<Brand>  {

  @Autowired
  BrandDao brandDao;

  @Override
  public List<Brand> findAll() {
    return null;
  }

  @Override
  public Brand save(Brand entity) {
    return null;
  }

  @Override
  public Optional<Brand> findById(Long id) {
    return brandDao.findById(id);
  }

  @Override
  public void delete(Brand entity) {

  }

  @Override
  public void deleteById(Long id) {

  }


}
