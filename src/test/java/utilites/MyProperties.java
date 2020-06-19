package utilites;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyProperties {
    public static Properties getProperties(String pathToProperties) {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream(pathToProperties)) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }
}
