package BigIdeaREST.restservices;

import BigIdeaREST.handlers.ICustomerHandler;
import BigIdeaREST.response.Reply;
import models.Customer;
import utils.GsonUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/support/customer")
public class CustomerService {
    private static ICustomerHandler handler;

    public static void setHandler(ICustomerHandler handler) {
        CustomerService.handler = handler;
    }

    @GET
    @Path("/all")
    public Response getCustomers() {
        Reply reply = handler.getCustomers();

        return Response.status(reply.getStatus().getCode()).entity(reply.getMessage()).build();
    }

    @GET
    @Path("/{id}")
    public Response getCustomer(@PathParam("id") int customerId) {
        Reply reply = handler.getCustomer(customerId);

        return Response.status(reply.getStatus().getCode()).entity(reply.getMessage()).build();
    }

    @POST
    @Path("/save")
    @Consumes("application/json")
    public Response saveCustomer(String data) {
        Customer customer = GsonUtils.fromJson(data, Customer.class);

        Reply reply = handler.saveCustomer(customer);

        return Response.status(reply.getStatus().getCode()).entity(reply.getMessage()).build();
    }

    @PUT
    @Path("/edit")
    @Consumes("application/json")
    public Response editCustomer(String data) {
        Customer customer = GsonUtils.fromJson(data, Customer.class);

        Reply reply = handler.saveCustomer(customer);

        return Response.status(reply.getStatus().getCode()).entity(reply.getMessage()).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes("application/json")
    public Response deleteCustomer(@PathParam("id") int customerId) {
        Reply reply = handler.deleteCustomer(customerId);

        return Response.status(reply.getStatus().getCode()).entity(reply.getMessage()).build();
    }
}
