package webDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Prop {
    public static java.util.Properties getProp() {
        java.util.Properties prop = new java.util.Properties();
        try (InputStream input = new FileInputStream("src/test/resources/booking.properties")) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }
}
