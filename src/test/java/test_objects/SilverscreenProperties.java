package test_objects;

import utilites.MyProperties;

import java.util.Properties;

public class SilverscreenProperties {
    static Properties properties = MyProperties.getProperties("src/test/resources/silverscreen");
    public String urlSilverscreen=properties.getProperty("URL_SILVERSCREEN");
    public String searchWord=properties.getProperty("SEARCH_WORD");
    public String email=properties.getProperty("EMAIL");
    public String wrongEmail=properties.getProperty("WRONG_EMAIL");
    public String password= properties.getProperty("PASSWORD");
}
