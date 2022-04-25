import DataAccess.ConnectDB;
import DataAccess.EmployeeDBAccess;
import UserInterface.EmployeeWindow;
import UserInterface.LoginWindow;
import UserInterface.RepairSheetPanel;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LoginWindow firstWindow = new LoginWindow();
        EmployeeWindow employeeWindow = new EmployeeWindow();


        //ConnectDB connection = new ConnectDB();

        /*
        EmployeeDBAccess employeeDBAccess = new EmployeeDBAccess();
        ArrayList<String> tests = employeeDBAccess.getEmployeeEMail();

        for (String test : tests) {
            System.out.println(test);
        }
        */
    }
}
