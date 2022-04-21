package DataAccess;

import Model.Register;
import Exception.AddRegisterException;

import java.awt.print.Book;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class RegisterDBAccess {
    private ConnectDB connection = new ConnectDB();

    public RegisterDBAccess() {

    }
    public void addRegister(Register register) throws AddRegisterException {
        String query = "INSERT";
    }
}
