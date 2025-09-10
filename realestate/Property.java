package realestate;
import java.io.Serializable;

public abstract class Property implements Serializable {
    protected String id;
    protected String address;
    protected double price;
    private static final long serialVersionUID = 1L;

    public Property(String id, String address, double price) {
        this.id = id;
        this.address = address;
        this.price = price;
    }
    public String getId() {
        return id;
    }
    public abstract void displayInfo();
}
