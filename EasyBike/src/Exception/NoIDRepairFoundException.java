package Exception;

public class NoIDRepairFoundException extends Exception {
    private String error;

    public NoIDRepairFoundException(String error) {
        this.error = error;
    }

    public String getMessage() {
        return error + " est introuvable !";
    }
}
