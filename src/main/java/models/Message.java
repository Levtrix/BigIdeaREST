package models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "message_table")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "messagetext", nullable = false)
    private String messageText;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creationdate", nullable = false)
    private Date creationDate;

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }


    // Constructors
    public Message() {

    }

    public Message(String messageText, Date creationDate) {
        this.messageText = messageText;
        this.creationDate = creationDate;
    }

    public Message(int id, String messageText, Date creationDate) {
        this.id = id;
        this.messageText = messageText;
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return messageText;
    }
}
