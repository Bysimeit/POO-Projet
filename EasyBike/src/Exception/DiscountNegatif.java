package Exception;

public class DiscountNegatif extends Exception{
    private Double badValue;

    public DiscountNegatif(Double badValue){
        this.badValue = badValue;
    }

    @Override
    public String getMessage() {
        return "La valeur " + badValue + " est mauvaise !";
    }
}
