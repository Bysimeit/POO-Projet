package Controller;

import java.util.ArrayList;

public interface EmployeeDataAccess {
    public ArrayList<String> getEmployeeEMail();
    public void loginConnection(String eMail, String password);
}
