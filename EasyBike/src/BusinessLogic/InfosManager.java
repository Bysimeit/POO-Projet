package BusinessLogic;

import Controller.EmployeeDataAccess;
import Controller.MemberDataAccess;
import DataAccess.EmployeeDBAccess;
import DataAccess.MemberDBAccess;
import Model.Locality;
import Model.Register;
import Model.ResearchInfos1;

import java.util.ArrayList;

public class InfosManager {
    private MemberDataAccess memberDBAccess;
    private EmployeeDataAccess employeeDBAccess;

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

        return this.employeeDBAccess.getInfoEmployee(eMail);
    }

    public ArrayList<String> searchResponsibleInfo(int responsible) {
        return this.employeeDBAccess.getResponsibleInfo(responsible);
    }

    public ArrayList<Locality> pickAllLocality() {
        return this.memberDBAccess.pickAllLocality();
    }

    public ArrayList<ResearchInfos1> selectResearchInfos1(int idLocality) {
        return this.memberDBAccess.selectResearchInfos1(idLocality);
    }
}
