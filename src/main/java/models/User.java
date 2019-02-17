package models;

import javax.persistence.*;

@Entity
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "emaailaddress")
    private String emailaddress;

    @Column(name = "password")
    private String password;

    //@Column
    //private Token token;

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Constructors
    public User() {}

    public User(String emailaddress, String password) {
        this.emailaddress = emailaddress;
        this.password = password;
    }

    public User(String firstName, String lastName, String emailaddress, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailaddress = emailaddress;
        this.password = password;
    }

    public User(int id, String firstName, String lastName, String emailaddress, String password, Token token) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailaddress = emailaddress;
        this.password = password;
        //tis.token = token;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
