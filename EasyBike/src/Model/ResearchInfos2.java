package Model;

import java.util.Date;

public class ResearchInfos2 {
    private Integer id;
    private String name;
    private Date date;
    private Integer number;
    private Integer bikeNumber;

    public ResearchInfos2(Integer id, String name, Date date, Integer number, Integer bikeNumber) {
        setId(id);
        setName(name);
        setDate(date);
        setNumber(number);
        setBikeNumber(bikeNumber);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setBikeNumber(Integer bikeNumber) {
        this.bikeNumber = bikeNumber;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getBikeNumber() {
        return bikeNumber;
    }
}
