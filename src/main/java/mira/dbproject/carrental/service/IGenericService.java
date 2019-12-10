package mira.dbproject.carrental.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

public interface IGenericService<T> {


  List<T> findAll();

  @Transactional
  T save(T entity);

  @Transactional
  Optional<T> findById(Long id);

  @Transactional
  void delete(T entity);

  @Transactional
  void deleteById(Long id);

  Long count();
}