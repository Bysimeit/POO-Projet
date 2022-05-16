package Controller;

import BusinessLogic.InfosManager;
import BusinessLogic.LoginManager;
import BusinessLogic.RegisterManager;
import BusinessLogic.RepairSheetManager;
import Model.Register;
import Exception.AddRegisterException;
import Model.Repair;

import java.util.ArrayList;

public class ApplicationController {
    private RegisterManager registerManager;
    private InfosManager infosManager;
    private RepairSheetManager repairSheetManager;

    public ApplicationController() {
        setRegisterManager(new RegisterManager());
        setInfosManager(new InfosManager());
        setRepairSheetManager(new RepairSheetManager());
    }

    public void setRegisterManager(RegisterManager newManager) {
        this.registerManager = newManager;
    }

    public void setInfosManager(InfosManager newInfosManager) {
        this.infosManager = newInfosManager;
    }

    public void setRepairSheetManager(RepairSheetManager repairSheetManager) {
        this.repairSheetManager = repairSheetManager;
    }

    public void addRegister(ArrayList<Register> registerInfos) throws AddRegisterException {
        registerManager.addRegister(registerInfos);
    }

    public boolean loginConnection(Register loginID, Boolean isMember) {
        LoginManager login = new LoginManager();

        return login.loginConnection(loginID, isMember);
    }

    public ArrayList<String> searchEmployeeInfo(Register loginID) {
        return infosManager.searchEmployeeInfo(loginID);
    }

    public ArrayList<String> searchResponsibleInfo(int responsible) {
        return infosManager.searchResponsibleInfo(responsible);
    }

    public void addRepairSheet(Repair newRepair) {
        this.repairSheetManager.addRepairSheet(newRepair);
    }

    public ArrayList<String> searchRepairSheet(int idRepairSheet) {
        return this.repairSheetManager.searchRepairSheetInfos(idRepairSheet);
    }

    public void modifyRepairSheet(Repair modifyRepair) {
        this.repairSheetManager.modifyRepairSheet(modifyRepair);
    }

    public void delRepairSheet(int idRepairSheet) {
        this.repairSheetManager.delRepairSheet(idRepairSheet);
    }

    public ArrayList<Repair> selectAllRepair() {
        return this.repairSheetManager.selectAllRepair();
    }
}
