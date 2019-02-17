package models;

import javax.persistence.*;

@Entity
@Table(name = "company_table")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "postalcode", nullable = false)
    private String postalCode;

    @Column(name = "address", nullable = false)
    private String address;

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Constructors
    public Company() {}

    public Company(String name, String postalCode, String address) {
        this.name = name;
        this.postalCode = postalCode;
        this.address = address;
    }

    public Company(int id, String name, String postalCode, String address) {
        this.id = id;
        this.name = name;
        this.postalCode = postalCode;
        this.address = address;
    }

    @Override
    public String toString() {
        return name;
    }
}
