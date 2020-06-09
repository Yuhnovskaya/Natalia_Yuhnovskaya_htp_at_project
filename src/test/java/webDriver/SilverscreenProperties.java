package webDriver;

import java.util.Properties;

public class SilverscreenProperties {
    static Properties properties = MyProperties.getProperties("src/test/resources/silverscreen");
    private String urlSilverscreen=properties.getProperty("URL_SILVERSCREEN");
    private String searchWord=properties.getProperty("SEARCH_WORD", "utf-8");
    private String email=properties.getProperty("EMAIL");
    private String wrongEmail=properties.getProperty("WRONG_EMAIL");
    private String password= properties.getProperty("PASSWORD");

    public static Properties getProperties() {
        return properties;
    }

    public String getUrlSilverscreen() {
        return urlSilverscreen;
    }

    public String getSearchWord() {
        return searchWord;
    }

    public String getEmail() {
        return email;
    }

    public String getWrongEmail() {
        return wrongEmail;
    }

    public String getPassword() {
        return password;
    }
}
