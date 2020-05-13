package webDriver;

import org.openqa.selenium.WebDriver;

import static webDriver.webDriver.*;

public class DrManager {
    public static WebDriver driver;
    public static WebDriver getDriver(Config config){
        switch (config){
            case CHROME:
                return getChromeDriver();
            case FF:
                return getFirefoxDriver();
            case IEll:
                return getIEllDriver();
            default:
                throw null;
        }
    }
}
