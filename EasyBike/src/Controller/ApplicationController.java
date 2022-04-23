package Controller;

import BusinessLogic.RegisterManager;
import Model.Register;
import Exception.AddRegisterException;

import java.util.ArrayList;

public class ApplicationController {
    private RegisterManager manager;

    public ApplicationController() {
        setManager(new RegisterManager());
    }

    public void setManager(RegisterManager newManager) {
        this.manager = newManager;
    }

    public void addRegister(ArrayList<Register> registerInfos) throws AddRegisterException {
        manager.addRegister(registerInfos);
    }

    public void loginConnection(Register loginID) {
        manager.loginConnection(loginID);
    }
}
