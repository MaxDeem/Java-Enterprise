package repositories;

import java.util.Optional;

public interface CrudRepository<T> {
    void create(T model);
    Optional<T> read(Long id);
    void update(Long id);
    void delete(Long id);
}
