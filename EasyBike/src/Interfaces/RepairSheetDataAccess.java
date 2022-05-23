package Interfaces;

import Exception.AddRepairException;
import Model.Repair;

import java.util.ArrayList;

public interface RepairSheetDataAccess {
    public void addRepairSheet(int id, int idEmployee, String startDate, String endDate, boolean isUrgent, String remark, int bikeNumber, String transmittingStation) throws AddRepairException;
    public ArrayList<String> searchSheetInfos(int idRepairSheet);
    public void modifyRepairSheet(int id, int idEmployee, String startDate, String endDate, boolean isUrgent, String remark, int bikeNumber, String transmittingStation);
    public void delRepairSheet(int id);
    public ArrayList<Repair> selectAllRepair();
    public ArrayList<Integer> getAllBikeNumber();
}
