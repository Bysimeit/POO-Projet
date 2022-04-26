package BusinessLogic;

import Controller.MemberDataAccess;
import DataAccess.EmployeeDBAccess;
import DataAccess.MemberDBAccess;
import Model.Register;

import java.util.ArrayList;

public class InfosManager {
    private MemberDataAccess memberDBAccess;
    private EmployeeDBAccess employeeDBAccess;

    public InfosManager() {
        setMemberDataAccess(new MemberDBAccess());
        setEmployeeDataAccess(new EmployeeDBAccess());
    }

    public void setMemberDataAccess(MemberDataAccess newMemberDBAccess) {
        this.memberDBAccess = newMemberDBAccess;
    }

    public void setEmployeeDataAccess(EmployeeDBAccess newEmployeeDBAccess) {
        this.employeeDBAccess = newEmployeeDBAccess;
    }

    public ArrayList<String> searchEmployeeInfo(Register loginID) {
        String eMail = loginID.getStringList().get(0);

        return employeeDBAccess.getInfoEmployee(eMail);
    }

    public ArrayList<String> searchResponsibleInfo(int responsible) {
        return employeeDBAccess.getResponsibleInfo(responsible);
    }
}
