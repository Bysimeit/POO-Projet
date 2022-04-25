package Controller;

import BusinessLogic.LoginManager;
import BusinessLogic.RegisterManager;
import Model.Register;
import Exception.AddRegisterException;

import java.util.ArrayList;

public class ApplicationController {
    private RegisterManager register;

    public ApplicationController() {
        setManager(new RegisterManager());
    }

    public void setManager(RegisterManager newManager) {
        this.register = newManager;
    }

    public void addRegister(ArrayList<Register> registerInfos) throws AddRegisterException {
        register.addRegister(registerInfos);
    }

    public void loginConnection(Register loginID) {
        LoginManager login = new LoginManager();
        login.loginConnection(loginID);
    }
}
