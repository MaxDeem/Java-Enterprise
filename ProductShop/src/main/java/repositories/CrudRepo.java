package repositories;

import models.Customer;

import java.util.List;
import java.util.Optional;

public interface CrudRepo<T> {
    Optional<T> findOne(Long id);
    void save(T model);
    void delete(Long id);
    List<T> findAll();

}
