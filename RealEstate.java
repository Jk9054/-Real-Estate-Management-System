import realestate.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RealEstate implements PropertyManager {
    private List<Property> properties = new ArrayList<>();

    public void addProperty(Property property) {
        properties.add(property);
    }

    public void removeProperty(String id) throws Exception {
        Property toRemove = null;
        for (Property property : properties) {
            if (property.getId().equals(id)) {
                toRemove = property;
                break;
            }
        }
        if (toRemove != null) {
            properties.remove(toRemove);
            System.out.println("Property removed.");
        } else {
            throw new Exception("Property with ID " + id + " not found.");
        }
    }

    public void listProperties() {
        if (properties.isEmpty()) {
            System.out.println("No properties available.");
        } else {
            for (Property property : properties) {
                property.displayInfo();
                System.out.println("------------");
            }
        }
    }

    public void saveProperties() {
        try {
            PropertyDatabase.saveProperties(properties);
            System.out.println("Properties saved successfully.");
        } catch (Exception e) {
            System.out.println("Error saving properties: " + e.getMessage());
        }
    }

    public void loadProperties() {
        try {
            properties = PropertyDatabase.loadProperties();
            System.out.println("Properties loaded successfully.");
        } catch (Exception e) {
            System.out.println("Error loading properties: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        RealEstate realEstate = new RealEstate();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\nReal Estate Management System");
            System.out.println("1. Add Residential Property");
            System.out.println("2. Add Commercial Property");
            System.out.println("3. List Properties");
            System.out.println("4. Remove Property");
            System.out.println("5. Save Properties");
            System.out.println("6. Load Properties");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter ID: ");
                    String rId = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String rAddress = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double rPrice = scanner.nextDouble();
                    System.out.print("Enter Bedrooms: ");
                    int bedrooms = scanner.nextInt();
                    System.out.print("Enter Bathrooms: ");
                    int bathrooms = scanner.nextInt();
                    scanner.nextLine();
                    realEstate.addProperty(new Residential(rId, rAddress, rPrice, bedrooms, bathrooms));
                    break;
                case "2":
                    System.out.print("Enter ID: ");
                    String cId = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String cAddress = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double cPrice = scanner.nextDouble();
                    System.out.print("Enter Area (sq ft): ");
                    double area = scanner.nextDouble();
                    scanner.nextLine();
                    realEstate.addProperty(new Commercial(cId, cAddress, cPrice, area));
                    break;
                case "3":
                    realEstate.listProperties();
                    break;
                case "4":
                    System.out.print("Enter Property ID to remove: ");
                    String id = scanner.nextLine();
                    try {
                        realEstate.removeProperty(id);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "5":
                    realEstate.saveProperties();
                    break;
                case "6":
                    realEstate.loadProperties();
                    break;
                case "0":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (!choice.equals("0"));

        scanner.close();
    }
}