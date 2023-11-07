package readers.property;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

/**
 * The "PropertyReader" class provides utility methods to read, modify, and store properties
 * from a specified .properties file.
 *
 * Usage Example:
 * '''
 * PropertyReader reader = PropertyReader.read("custom_config");
 * String value = reader.get("key");
 * reader.set("newKey", "newValue");
 * reader.store("Updated properties");
 * '''
 *
 * @version 1.0
 * @author [Hasan Özyer]
 */

public class PropertyReader {

    Properties properties = new Properties();
    String file;

    /**
     * Constructs a "PropertyReader" object by loading properties from the specified file.
     *
     * @param fileName The name of the .properties file (without extension) to be read.
     * @throws RuntimeException If there is an error loading the properties file.
     */
    public PropertyReader(String fileName) {
        try {
            this.file = "src/test/resources/datafiles/" + fileName + ".properties";
            FileReader fileReader = new FileReader(file);
            properties.load(fileReader);
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

    /**
     * Static factory method that creates a "PropertyReader" object with a default file name ("config.properties").
     *
     * @return A "PropertyReader" object initialized with default properties file.
     */
    public static PropertyReader read() {
        return read("config");
    }

    /**
     * Static factory method that creates a "PropertyReader" object with a specified file name.
     *
     * @param fileName The name of the .properties file (without extension) to be read.
     * @return "PropertyReader" object initialized with the specified properties file.
     */
    public static PropertyReader read(String fileName) {
        return new PropertyReader(fileName);
    }


    /**
     * Retrieves the value of a property associated with the given key.
     *
     * @param key The key of the property.
     * @return The value of the property, or null if the key is not found.
     */
    public String get(String key) {
        return properties.getProperty(key);
    }

    /**
     * Sets the value of a property identified by the specified key.
     *
     * @param key The key of the property.
     * @param value The new value to be set for the property.
     */
    public void set(String key, String value) {
        properties.setProperty(key, value);
    }

    /**
     * Deletes a property identified by the specified key.
     *
     * @param key The key of the property to be removed.
     */
    public void del(String key, String value) {
        properties.remove(key);
    }

    /**
     * Stores the properties back to the file with an optional comment.
     *
     * @param comment A comment to be written at the beginning of the properties file.
     */
    public void store(String comment) {
        try {

            FileWriter fileWriter = new FileWriter(file);
            properties.store(fileWriter, comment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
