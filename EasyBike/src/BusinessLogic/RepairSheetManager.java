package BusinessLogic;

import Controller.RepairSheetDataAccess;
import DataAccess.RepairSheetDBAccess;
import Model.Register;
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

    public void addRepairSheet(ArrayList<Register> repairSheetInfos, int idEmployee, boolean isUrgent) {
        this.repairInfos = repairSheetInfos;
        String[] relayInfos = new String[5];

        String remark = "";
        String transmittingStation = "";
        int i = 0;
        for (Register repairInfo : this.repairInfos) {
            if (i == 3) remark = repairInfo.getInsert();
            if (i == 4) transmittingStation = repairInfo.getInsert();
            relayInfos[i] = repairInfo.getTextField();
            i++;
        }

        repairSheetDataAccess.addRepairSheet(relayInfos[0], idEmployee, relayInfos[1], relayInfos[2], isUrgent, remark, transmittingStation);
    }
}
