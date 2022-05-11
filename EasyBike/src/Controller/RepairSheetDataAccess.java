package Controller;

import Model.Register;

import java.util.ArrayList;

public interface RepairSheetDataAccess {
    public void addRepairSheet(String id, int idEmployee, String startDate, String endDate, boolean isUrgent, String remark, String transmittingStation);
    public ArrayList<String> searchSheetInfos(int idRepairSheet);

    public void modifyRepairSheet(String id, int idEmployee, String startDate, String endDate, boolean isUrgent, String remark, String transmittingStation);
    public void delRepairSheet(int id);
}
