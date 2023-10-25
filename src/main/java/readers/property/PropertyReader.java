package readers.property;

import com.beust.jcommander.StringKey;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

public class PropertyReader {

    Properties properties = new Properties();
    FileReader fileReader;
    FileWriter fileWriter;
    String file;

    public PropertyReader(String fileName) {
        try {
            file = "src/main/resources/" + fileName + ".properties";
            fileReader = new FileReader(file);
            properties.load(fileReader);

        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

    /**
     * This is a static factory method that creates a PropertyReader object with a default file name ("config.properties").
     * It provides a convenient way to create a PropertyReader without specifying a file name each time.
     * @return
     */

    public static PropertyReader read() {
        return read("config");
    }

    public static PropertyReader read(String fileName) {
        return new PropertyReader(fileName);
    }

    public String get(String key) {
        return properties.getProperty(key);
    }

/*    public void set(String key, String value) {
        properties.setProperty(key, value);
    }

    public void del(String key, String value) {
        properties.remove(key);
    }

    public void store(String comment) {
        try {
            fileWriter = new FileWriter(file);
            properties.store(fileWriter, comment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

 */

}
