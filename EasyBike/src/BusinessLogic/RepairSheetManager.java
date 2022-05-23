package BusinessLogic;

import Exception.AddRepairException;
import Exception.NoIDRepairFoundException;

import Interfaces.RepairSheetDataAccess;
import DataAccess.RepairSheetDBAccess;
import Model.Repair;

import java.util.ArrayList;

public class RepairSheetManager {
    private RepairSheetDataAccess repairSheetDataAccess;

    public RepairSheetManager() {
        setRepairSheetPanel(new RepairSheetDBAccess());
    }

    public void setRepairSheetPanel(RepairSheetDataAccess newRepairSheetDBAccess) {
        this.repairSheetDataAccess = newRepairSheetDBAccess;
    }

    public void addRepairSheet(Repair newRepair) throws AddRepairException {
        this.repairSheetDataAccess.addRepairSheet(newRepair.getId(), newRepair.getEmployeeId(), newRepair.getDate(), newRepair.getFinishDate(), newRepair.getIsUrgent(), newRepair.getRemark(), newRepair.getBikeNumber(), newRepair.getStation());
    }

    public ArrayList<String> searchRepairSheetInfos(int idRepairSheet) throws NoIDRepairFoundException {
        return this.repairSheetDataAccess.searchSheetInfos(idRepairSheet);
    }

    public void modifyRepairSheet(Repair modifyRepair) {
        this.repairSheetDataAccess.modifyRepairSheet(modifyRepair.getId(), modifyRepair.getEmployeeId(), modifyRepair.getDate(), modifyRepair.getFinishDate(), modifyRepair.getIsUrgent(), modifyRepair.getRemark(), modifyRepair.getBikeNumber(), modifyRepair.getStation());
    }

    public void delRepairSheet(int idRepairSheet) {
        this.repairSheetDataAccess.delRepairSheet(idRepairSheet);
    }

    public ArrayList<Repair> selectAllRepair() {
        return this.repairSheetDataAccess.selectAllRepair();
    }

    public ArrayList<Integer> pickAllBike() {
        return this.repairSheetDataAccess.getAllBikeNumber();
    }
}
