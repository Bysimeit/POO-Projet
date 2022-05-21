package Interfaces;

import Model.Register;
import Model.Repair;

import java.util.ArrayList;

public interface RepairSheetDataAccess {
    public void addRepairSheet(int id, int idEmployee, java.sql.Date startDate, java.sql.Date endDate, boolean isUrgent, String remark, int bikeNumber, String transmittingStation);
    public ArrayList<String> searchSheetInfos(int idRepairSheet);
    public void modifyRepairSheet(int id, int idEmployee, java.sql.Date startDate, java.sql.Date endDate, boolean isUrgent, String remark, int bikeNumber, String transmittingStation);
    public void delRepairSheet(int id);
    public ArrayList<Repair> selectAllRepair();
    public ArrayList<Integer> getAllBikeNumber();
}
