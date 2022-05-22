package Model;

import java.util.Date;

public class ResearchInfos3 {
    private Date startDate;
    private boolean isPaid;
    private double price;
    private int customerNumber;
    private String name;
    private String firstName;

    public ResearchInfos3(Date startDate, boolean isPaid, double price, int customerNumber, String name, String firstName) {
        setStartDate(startDate);
        setIsPaid(isPaid);
        setPrice(price);
        setCustomerNumber(customerNumber);
        setName(name);
        setFirstName(firstName);
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setIsPaid(boolean paid) {
        isPaid = paid;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public boolean getIsPaid() {
        return isPaid;
    }
}
