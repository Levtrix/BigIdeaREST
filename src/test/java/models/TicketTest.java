package models;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class TicketTest {
    private Ticket ticket;
    private Date date;

    @Before
    public void TestInitialize() {
        ticket = new Ticket(1, "Test ticket", "Test ticket om het systeem te testen", new Date());
        ticket.addMessage(new Message(1, "Het aanmaken van een ticket is gelukt", new Date()));
    }

    @Test
    public void TestAddMessage() {
        int listLenght = ticket.getMessages().size();
        ticket.addMessage(new Message(2, "Adding test message", new Date()));

        assertEquals(listLenght + 1, ticket.getMessages().size());
    }

    @Test
    public void TestEditMessage() {
        Message test = new Message(1, "Het aanpassen is gelukt", new Date());
        ticket.editMessage(test);

        for (Message m : ticket.getMessages()) {
            if (m.getId() == test.getId()) {
                assertEquals(test.getMessageText(), m.getMessageText());
                assertEquals(test.getCreationDate(), m.getCreationDate());
            }
        }
    }
}