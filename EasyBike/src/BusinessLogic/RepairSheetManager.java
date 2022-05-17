package BusinessLogic;

import Controller.RepairSheetDataAccess;
import DataAccess.RepairSheetDBAccess;
import Model.Register;
import Model.Repair;
import UserInterface.RepairSheetPanel;

import java.util.ArrayList;

public class RepairSheetManager {
    private RepairSheetDataAccess repairSheetDataAccess;
    private ArrayList<Register> repairInfos;

    public RepairSheetManager() {
        setRepairSheetPanel(new RepairSheetDBAccess());
    }

    public void setRepairSheetPanel(RepairSheetDataAccess newRepairSheetDBAccess) {
        this.repairSheetDataAccess = newRepairSheetDBAccess;
    }

    public void addRepairSheet(Repair newRepair) {
        this.repairSheetDataAccess.addRepairSheet(newRepair.getId(), newRepair.getEmployeeId(), newRepair.getDate(), newRepair.getFinishDate(), newRepair.getIsUrgent(), newRepair.getRemark(), newRepair.getStation());
    }

    public ArrayList<String> searchRepairSheetInfos(int idRepairSheet) {
        return this.repairSheetDataAccess.searchSheetInfos(idRepairSheet);
    }

    public void modifyRepairSheet(Repair modifyRepair) {
        this.repairSheetDataAccess.modifyRepairSheet(modifyRepair.getId(), modifyRepair.getEmployeeId(), modifyRepair.getDate(), modifyRepair.getFinishDate(), modifyRepair.getIsUrgent(), modifyRepair.getRemark(), modifyRepair.getStation());
    }

    public void delRepairSheet(int idRepairSheet) {
        this.repairSheetDataAccess.delRepairSheet(idRepairSheet);
    }

    public ArrayList<Repair> selectAllRepair() {
        return this.repairSheetDataAccess.selectAllRepair();
    }
}
