package Exception;

public class DiscountNegatifException extends Exception {
    private Double badValue;

    public DiscountNegatifException(Double badValue) {
        this.badValue = badValue;
    }

    @Override
    public String getMessage() {
        return "La valeur " + badValue + " est mauvaise !";
    }
}
