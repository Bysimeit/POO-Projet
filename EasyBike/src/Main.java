import DataAccess.ConnectDB;
import DataAccess.EmployeeDBAccess;
import Exception.JTextFieldException;
import Exception.JTextFieldEmptyException;
import UserInterface.LoginWindow;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws JTextFieldException, JTextFieldEmptyException {
        LoginWindow firstWindow = new LoginWindow();

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
