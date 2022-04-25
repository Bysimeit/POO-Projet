package Exception;

public class LoginConnectionException extends Exception {
    public String getMessage() {
        return "L'eMail et/ou le mot de passe est incorrect !";
    }
}
