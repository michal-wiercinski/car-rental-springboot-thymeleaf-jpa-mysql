package mira.dbproject.carrental.service.entityservice;

import java.util.Optional;
import mira.dbproject.carrental.domain.entity.Brand;
import mira.dbproject.carrental.repository.dao.BrandDao;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

  private final BrandDao brandDao;

  public BrandService(final BrandDao brandDao) {
    this.brandDao = brandDao;
  }

  public Optional<Brand> findById(Long id) {
    return brandDao.findById(id);
  }
}
