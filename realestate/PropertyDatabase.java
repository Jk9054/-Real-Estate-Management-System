package realestate;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PropertyDatabase {
    private static final String FILE_NAME = "properties.txt";

    public static void saveProperties(List<Property> properties) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(properties);
        } catch (IOException e) {
            System.err.println("Error saving properties: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static List<Property> loadProperties() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Property>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading properties: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();  // return empty list if loading fails
        }
    }
}
