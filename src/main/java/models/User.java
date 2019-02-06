package models;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    // Getters and setters


    // Constructors
    public User() {}


    @Override
    public String toString() {
        return "userfields";
    }
}
