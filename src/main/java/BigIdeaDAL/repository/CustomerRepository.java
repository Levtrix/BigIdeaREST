package BigIdeaDAL.repository;

import models.Customer;

public class CustomerRepository extends AbstractRepository<Customer, Integer> {
    @Override
    public Class<Customer> getDomainClass() {
        return Customer.class;
    }
}
