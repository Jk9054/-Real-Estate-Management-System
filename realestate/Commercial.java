package realestate;

public class Commercial extends Property{
    private double area;

    public Commercial(String id, String address, double price, double area) {
        super(id, address, price);
        this.area = area;
    }

    public void displayInfo() {
        System.out.println("Commercial Property - ID: " + id);
        System.out.println("Address: " + address);
        System.out.println("Price: $" + price);
        System.out.println("Area: " + area + " sq ft");
    }
}
