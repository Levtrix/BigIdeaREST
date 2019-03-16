package BigIdeaREST.response;

import models.Customer;
import models.Message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketJson {
    private int id;
    private String title;
    private String description;
    private List<Message> messages = new ArrayList<>();
    private Date creationDate;
    private Customer customer;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public TicketJson(int id, String title, String description, List<Message> messages, Date creationDate, Customer customer) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.messages = messages;
        this.creationDate = creationDate;
        this.customer = customer;
    }
}
