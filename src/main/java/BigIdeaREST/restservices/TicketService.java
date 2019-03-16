package BigIdeaREST.restservices;

import BigIdeaREST.handlers.ITicketHandler;
import BigIdeaREST.response.Reply;
import models.Ticket;
import utils.GsonUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/support/ticket")
public class TicketService {
    private static ITicketHandler handler;

    public static void setHandler(ITicketHandler handler) {
        TicketService.handler = handler;
    }

    @GET
    @Path("/all")
    public Response getTickets() {
        Reply reply = handler.getTickets();

        return Response.status(reply.getStatus().getCode()).entity(reply.getMessage()).build();
    }

    @GET
    @Path("/{id}")
    public Response getTicket(@PathParam("id") int ticketId) {
        Reply reply = handler.getTicket(ticketId);

        return Response.status(reply.getStatus().getCode()).entity(reply.getMessage()).build();
    }

    @POST
    @Path("/save")
    @Consumes("application/json")
    public Response saveTicket(String data) {
        Ticket ticket = GsonUtils.fromJson(data, Ticket.class);

        Reply reply = handler.saveTicket(ticket);

        return Response.status(reply.getStatus().getCode()).entity(reply.getMessage()).build();
    }

    @PUT
    @Path("/edit")
    @Consumes("application/json")
    public Response editTicket(String data) {
        Ticket ticket = GsonUtils.fromJson(data, Ticket.class);

        Reply reply = handler.saveTicket(ticket);

        return Response.status(reply.getStatus().getCode()).entity(reply.getMessage()).build();
    }

    // TODO: Decide if deleteTicket() method is going to be implemented
}
