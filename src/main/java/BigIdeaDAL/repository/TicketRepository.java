package BigIdeaDAL.repository;

import models.Ticket;

public class TicketRepository extends AbstractRepository<Ticket, Integer> {
    @Override
    public Class<Ticket> getDomainClass() {
        return Ticket.class;
    }
}
