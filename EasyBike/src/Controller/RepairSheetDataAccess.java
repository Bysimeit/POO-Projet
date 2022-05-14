package Controller;

import Model.Register;

import java.util.ArrayList;

public interface RepairSheetDataAccess {
    public void addRepairSheet(int id, int idEmployee, java.sql.Date startDate, java.sql.Date endDate, boolean isUrgent, String remark, String transmittingStation);
    public ArrayList<String> searchSheetInfos(int idRepairSheet);
    public void modifyRepairSheet(int id, int idEmployee, java.sql.Date startDate, java.sql.Date endDate, boolean isUrgent, String remark, String transmittingStation);
    public void delRepairSheet(int id);
}
