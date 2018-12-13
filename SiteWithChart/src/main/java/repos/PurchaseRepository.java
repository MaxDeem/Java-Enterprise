package repos;

import models.Customer;
import models.Product;

public interface PurchaseRepository extends CrudRepository{
    void save(Product product, Customer customer);
}
