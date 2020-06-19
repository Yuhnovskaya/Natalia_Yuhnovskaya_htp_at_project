package web_driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DrManager {
    public static WebDriver driver;

    public static WebDriver getDriver(Config config) {
        switch (config) {
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
    private static WebDriver getIEllDriver() {

        return new EdgeDriver();
    }

    private static WebDriver getFirefoxDriver() {
        return new FirefoxDriver();
    }

    private static WebDriver getChromeDriver() {
        return new ChromeDriver();
    }
}

