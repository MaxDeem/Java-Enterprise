package repositories;

import models.Customer;

import java.util.Optional;

public interface CustomerRepo extends CrudRepo<Customer> {
    Optional<Customer> findOneByEmail(String email);
}
