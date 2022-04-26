package Controller;

import BusinessLogic.InfosManager;
import BusinessLogic.LoginManager;
import BusinessLogic.RegisterManager;
import Model.Register;
import Exception.AddRegisterException;

import java.util.ArrayList;

public class ApplicationController {
    private RegisterManager registerManager;
    private InfosManager infosManager;

    public ApplicationController() {
        setRegisterManager(new RegisterManager());
        setInfosManager(new InfosManager());
    }

    public void setRegisterManager(RegisterManager newManager) {
        this.registerManager = newManager;
    }

    public void setInfosManager(InfosManager newInfosManager) {
        this.infosManager = newInfosManager;
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
}
