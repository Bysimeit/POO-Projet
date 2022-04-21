import DataAccess.ConnectBD;
import UserInterface.LoginWindows;
import UserInterface.RegisterWindow;
import Exception.JTextFieldException;
import Exception.JTextFieldEmptyException;

public class Main {
    public static void main(String[] args) throws JTextFieldException, JTextFieldEmptyException {
        //LoginWindows firstWindows = new LoginWindows();
        RegisterWindow registerWindow = new RegisterWindow();

        //ConnectBD connection = new ConnectBD();
    }
}
