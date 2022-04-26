package Controller;

import java.util.ArrayList;

public interface EmployeeDataAccess {
    public ArrayList<String> getEmployeeEMail();
    public boolean loginConnection(String eMail, String password);
    public ArrayList<String> getInfoEmployee(String eMail);
    public ArrayList<String> getResponsibleInfo(int responsibleID);
}
