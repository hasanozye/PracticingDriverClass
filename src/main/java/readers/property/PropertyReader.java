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
