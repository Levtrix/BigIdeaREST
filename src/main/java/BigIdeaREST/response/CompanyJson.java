package BigIdeaREST.response;

public class CompanyJson {
    private int id;
    private String name;
    private String postalcode;
    private String address;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public String getAddress() {
        return  address;
    }

    public CompanyJson(int id, String name, String postalCode, String address) {
        this.id = id;
        this.name = name;
        this.postalcode = postalCode;
        this.address = address;
    }
}
