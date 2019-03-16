package BigIdeaREST.handlers;

import BigIdeaDAL.repository.TicketRepository;
import BigIdeaREST.response.ErrorJson;
import BigIdeaREST.response.Reply;
import BigIdeaREST.response.Status;
import BigIdeaREST.response.TicketJson;
import com.google.gson.Gson;
import logging.Logger;
import models.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketHandler implements ITicketHandler {
    private TicketRepository ticketRepository;
    private Gson gson;

    public TicketHandler(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
        this.gson = new Gson();
    }

    @Override
    public Reply getTickets() {
        try {
            //addTickets();
            List<TicketJson> ticketResponse = new ArrayList<>();

            for (Ticket t : ticketRepository.findAll()) {
                ticketResponse.add(new TicketJson(t.getId(), t.getTitle(), t.getDescription(), t.getMessages(), t.getCreationDate(), t.getCustomer()));
            }

            String json = gson.toJson(ticketResponse);
            return new Reply(Status.OK, json);
        } catch (Exception e) {
            Logger.getInstance().log(e);
            ErrorJson errorJson = new ErrorJson("Something went wrong");

            return new Reply(Status.ERROR, gson.toJson(errorJson));
        }
    }

    @Override
    public Reply getTicket(int ticketId) {
        Ticket ticket = ticketRepository.findOne(ticketId);

        if (ticket != null) {
            String json = gson.toJson(ticket);

            return new Reply(Status.OK, json);
        }

        ErrorJson errorJson = new ErrorJson("Something went wrong");
        return new Reply(Status.ERROR, gson.toJson(errorJson));
    }

    @Override
    public Reply saveTicket(Ticket ticket) {
        Ticket saved = ticketRepository.save(ticket);

        if (saved.getId() == ticket.getId()) {
            return new Reply(Status.OK, gson.toJson(saved));
        }

        ErrorJson errorJson = new ErrorJson("Something went wrong");
        return new Reply(Status.ERROR, gson.toJson(errorJson));
    }

    private void addTickets() {
        //TODO: Add test ticket data
    }
}
