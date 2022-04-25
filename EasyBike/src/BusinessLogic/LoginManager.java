package BusinessLogic;

import Controller.EmployeeDataAccess;
import Controller.MemberDataAccess;
import DataAccess.EmployeeDBAccess;
import DataAccess.MemberDBAccess;
import Model.Register;

public class LoginManager {
    private MemberDataAccess memberDBAccess;
    private EmployeeDBAccess employeeDBAccess;

    public LoginManager() {
        setMemberDataAccess(new MemberDBAccess());
        setEmployeeDataAccess(new EmployeeDBAccess());
    }

    public void setMemberDataAccess(MemberDataAccess newMemberDBAccess) {
        this.memberDBAccess = newMemberDBAccess;
    }

    public void setEmployeeDataAccess(EmployeeDBAccess newEmployeeDBAccess) {
        this.employeeDBAccess = newEmployeeDBAccess;
    }

    public void loginConnection(Register loginID, Boolean isMember) {
        String eMail = loginID.getStringList().get(0);
        String password = loginID.getStringList().get(1);

        if (isMember) {
            memberDBAccess.loginConnection(eMail, password);
        } else {
            employeeDBAccess.loginConnection(eMail, password);
        }
    }
}
