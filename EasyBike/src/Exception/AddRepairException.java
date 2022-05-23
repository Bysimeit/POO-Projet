package Exception;

import java.sql.SQLException;

public class AddRepairException extends SQLException {
    private int id;

    public AddRepairException(int id) {
        this.id = id;
    }

    public String getMessage() {
        return "L'identifiant " + id + " existe déjà !";
    }
}
