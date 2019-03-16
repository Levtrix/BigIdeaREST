package BigIdeaREST.handlers;

import BigIdeaREST.response.Reply;
import models.Customer;

public interface ICustomerHandler {
    Reply getCustomers();
    Reply getCustomer(int customerId);
    Reply saveCustomer(Customer customer);
    Reply deleteCustomer(int customerId);
}
