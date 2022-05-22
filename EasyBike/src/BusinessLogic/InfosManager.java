package BusinessLogic;

import Interfaces.EmployeeDataAccess;
import Interfaces.MemberDataAccess;
import DataAccess.EmployeeDBAccess;
import DataAccess.MemberDBAccess;
import Model.*;

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

    public ArrayList<ResearchInfos2> selectResearchInfos2(String startDate, String finishDate) {
        return this.employeeDBAccess.selectResearchInfos2(startDate, finishDate);
    }

    public ArrayList<ResearchInfos3> selectResearchInfos3(String startDate) {
        return this.memberDBAccess.selectResearchInfos3(startDate);
    }
}
