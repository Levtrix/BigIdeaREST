package BigIdeaREST.response;

import models.Company;

public class CustomerJson {
    private int id;
    private String firstName;
    private String lastName;
    private Company company;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Company getCompany() {
        return company;
    }

    public CustomerJson(int id, String firstName, String lastName, Company company) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
    }
}
