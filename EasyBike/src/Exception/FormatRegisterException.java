package Exception;

public class FormatRegisterException extends Exception {
    private String name;

    public FormatRegisterException(String name) {
        this.name = name;
    }

    public String getMessage() {
        return "Le champ " + name + " n'est pas au bon format !";
    }
}
