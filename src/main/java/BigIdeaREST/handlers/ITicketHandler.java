package BigIdeaREST.handlers;

import BigIdeaREST.response.Reply;
import models.Ticket;

public interface ITicketHandler {
    Reply getTickets();
    Reply getTicket(int ticketId);
    Reply saveTicket(Ticket ticket);
}
