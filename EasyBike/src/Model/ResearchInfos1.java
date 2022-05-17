package Model;

public class ResearchInfos1 {
    private Integer nationalNumber;
    private String firstName;
    private String name;
    private String street;
    private Integer houseNumber;
    private Integer customerNumber;
    private double price;

    public ResearchInfos1(Integer nationalNumber, String firstName, String name, String street, Integer houseNumber, Integer customerNumber, double price) {
        setNationalNumber(nationalNumber);
        setFirstName(firstName);
        setName(name);
        setStreet(street);
        setHouseNumber(houseNumber);
        setCustomerNumber(customerNumber);
        setPrice(price);
    }

    public void setNationalNumber(Integer nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNationalNumber() {
        return nationalNumber;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public double getPrice() {
        return price;
    }
}
