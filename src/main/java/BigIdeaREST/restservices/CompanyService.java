package BigIdeaREST.restservices;

import BigIdeaREST.handlers.ICompanyHandler;
import BigIdeaREST.response.Reply;
import models.Company;
import utils.GsonUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/support/company")
public class CompanyService {
    private static ICompanyHandler handler;

    public static void setHandler(ICompanyHandler handler) {
        CompanyService.handler = handler;
    }

    @GET
    @Path("/all")
    public Response getCompanies() {
        Reply reply = handler.getCompanies();

        return Response.status(reply.getStatus().getCode()).entity(reply.getMessage()).build();
    }

    @GET
    @Path("/{id}")
    public Response getCompany(@PathParam("id") int companyId) {
        Reply reply = handler.getCompany(companyId);

        return Response.status(reply.getStatus().getCode()).entity(reply.getMessage()).build();
    }

    @POST
    @Path("/save")
    @Consumes("application/json")
    public Response saveCompany(String data) {
        Company company = GsonUtils.fromJson(data, Company.class);

        Reply reply = handler.saveCompany(company);

        return Response.status(reply.getStatus().getCode()).entity(reply.getMessage()).build();
    }

    @PUT
    @Path("/edit")
    @Consumes("application/json")
    public Response editCompany(String data) {
        Company company = GsonUtils.fromJson(data, Company.class);

        Reply reply = handler.saveCompany(company);

        return Response.status(reply.getStatus().getCode()).entity(reply.getMessage()).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes("application/json")
    public Response deleteCompany(@PathParam("id") int companyId) {
        Reply reply = handler.deleteCompany(companyId);

        return Response.status(reply.getStatus().getCode()).entity(reply.getMessage()).build();
    }
}
