package mira.dbproject.carrental.service.viewservice;

import java.util.List;
import java.util.Optional;

public interface ICarViewService<T> {

  List<T> findAll();

  List<T> findAllAvailable();

  Optional<T> findById(Long id);


}
