package repositories;

import java.util.Optional;

public class CrudRepositoryImpl implements CrudRepository{

    //language = sql
    private static final String SQL_CREATE_QUERY = "insert into "
    @Override
    public void create(Object model) {

    }

    @Override
    public Optional read(Long id) {
        return Optional.empty();
    }

    @Override
    public void update(Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}
