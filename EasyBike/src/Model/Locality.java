package Model;

public class Locality {
    private int id;
    private int postalCode;
    private String name;

    public Locality(int id, int postalCode, String name) {
        setId(id);
        setPostalCode(postalCode);
        setName(name);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getName() {
        return name;
    }
}
