package realestate;

public class Residential extends Property{
    private int bedrooms;
    private int bathrooms;

    public Residential(String id, String address, double price, int bedrooms, int bathrooms) {
        super(id, address, price);
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
    }

    public void displayInfo() {
        System.out.println("Residential Property - ID: " + id);
        System.out.println("Address: " + address);
        System.out.println("Price: $" + price);
        System.out.println("Bedrooms: " + bedrooms + ", Bathrooms: " + bathrooms);
    }
}