package Model;

import java.sql.Date;

public class Repair {
    private Integer id;
    private Integer employeeId;
    private Date date;
    private Date finishDate;
    private Boolean isUrgent;
    private String remark;
    private Integer bikeNumber;
    private String station;

    public Repair(Integer id, Integer employeeId, Date date, Date finishDate, Boolean isUrgent, String remark, Integer bikeNumber, String station) {
        setId(id);
        setEmployeeId(employeeId);
        setDate(date);
        setFinishDate(finishDate);
        setUrgent(isUrgent);
        setRemark(remark);
        setBikeNumber(bikeNumber);
        setStation(station);
    }

    public Repair(Integer id, Integer employeeId, Date date, Date finishDate, Boolean isUrgent, String remark, String station) {
        setId(id);
        setEmployeeId(employeeId);
        setDate(date);
        setFinishDate(finishDate);
        setUrgent(isUrgent);
        setRemark(remark);
        setStation(station);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public void setUrgent(Boolean urgent) {
        isUrgent = urgent;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setBikeNumber(Integer bikeNumber) {
        this.bikeNumber = bikeNumber;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public Integer getId() {
        return id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public Date getDate() {
        return date;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public Boolean getIsUrgent(){
        return isUrgent;
    }

    public String getRemark() {
        return remark;
    }

    public Integer getBikeNumber() {
        return bikeNumber;
    }

    public String getStation() {
        return station;
    }
}
