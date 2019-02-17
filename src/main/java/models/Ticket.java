package models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ticket_id")
    @Fetch(FetchMode.SELECT)
    private List<Message> messages = new ArrayList<>();;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creationdate", nullable = false)
    private Date creationDate;

    // Getters and setters
    public int getId() {
        return this.id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Message> getMessages() {
        return Collections.unmodifiableList(messages);
    }

    public void setMessages(List<Message> messages) {
        this.messages.clear();
        this.messages.addAll(messages);
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }


    // Constructors
    public Ticket() {}

    public Ticket(String title, String description, Date creationDate) {
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
    }

    public Ticket(int id, String title, String description, Date creationDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
    }

    // Methods
    public void addMessage(Message message) {
        messages.add(message);
    }

    public void editMessage(Message message) {
        for (Message m : messages) {
            if (m.getId() == message.getId()) {
                m.setMessageText(message.getMessageText());
                m.setCreationDate(message.getCreationDate());
            }
        }
    }

    @Override
    public String toString() {
        return title;
    }
}
