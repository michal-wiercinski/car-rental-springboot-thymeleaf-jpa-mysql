package mira.dbproject.carrental.service.viewservice;

import java.util.List;

public interface ICarViewService<T> {

  List<T> findAll();
}
