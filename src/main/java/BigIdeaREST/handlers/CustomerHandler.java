package BigIdeaREST.handlers;

import BigIdeaDAL.repository.CustomerRepository;
import BigIdeaREST.response.CustomerJson;
import BigIdeaREST.response.ErrorJson;
import BigIdeaREST.response.Reply;
import BigIdeaREST.response.Status;
import com.google.gson.Gson;
import logging.Logger;
import models.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerHandler implements ICustomerHandler {
    private CustomerRepository customerRepository;
    private Gson gson;

    public CustomerHandler(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.gson = new Gson();
    }

    @Override
    public Reply getCustomers() {
        try {
            //addCustomers();
            List<CustomerJson> customerResponse = new ArrayList<>();

            for (Customer c : customerRepository.findAll()) {
                customerResponse.add(new CustomerJson(c.getId(), c.getFirstName(), c.getLastName(), c.getCompany()));
            }

            String json = gson.toJson(customerResponse);
            return new Reply(Status.OK, json);
        } catch (Exception e) {
            Logger.getInstance().log(e);
            ErrorJson errorJson = new ErrorJson("Something went wrong");

            return new Reply(Status.ERROR, gson.toJson(errorJson));
        }
    }

    @Override
    public Reply getCustomer(int customerId) {
        Customer customer = customerRepository.findOne(customerId);

        if (customer != null) {
            String json = gson.toJson(customer);

            return new Reply(Status.OK, json);
        }

        ErrorJson errorJson = new ErrorJson("Something went wrong");
        return new Reply(Status.ERROR, gson.toJson(errorJson));
    }

    @Override
    public Reply saveCustomer(Customer customer) {
        Customer saved = customerRepository.save(customer);

        if (saved.getId() == customer.getId()) {
            return new Reply(Status.OK, gson.toJson(saved));
        }

        ErrorJson errorJson = new ErrorJson("Something went wrong");
        return new Reply(Status.ERROR, gson.toJson(errorJson));
    }

    @Override
    public Reply deleteCustomer(int customerId) {
        try {
            customerRepository.delete(customerId);
            ErrorJson messageJson = new ErrorJson("Deleted");

            return new Reply(Status.OK, gson.toJson(messageJson));
        } catch (Exception e) {
            ErrorJson errorJson = new ErrorJson("Something went wrong");
            return new Reply(Status.ERROR, gson.toJson(errorJson));
        }
    }

    private void addCustomers() {
        //TODO: Add test customer data
    }
}
