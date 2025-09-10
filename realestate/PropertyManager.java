package realestate;

public interface PropertyManager {
    void addProperty(Property property);
    void removeProperty(String id) throws Exception;
    void listProperties();
}