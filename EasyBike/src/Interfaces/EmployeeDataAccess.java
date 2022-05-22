package Interfaces;

import Model.ResearchInfos2;
import Model.ResearchInfos3;

import java.util.ArrayList;

public interface EmployeeDataAccess {
    public ArrayList<String> getEmployeeEMail();
    public boolean loginConnection(String eMail, String password);
    public ArrayList<String> getInfoEmployee(String eMail);
    public ArrayList<String> getResponsibleInfo(int responsibleID);
    public ArrayList<ResearchInfos2> selectResearchInfos2(String startDate, String finishDate);
}
