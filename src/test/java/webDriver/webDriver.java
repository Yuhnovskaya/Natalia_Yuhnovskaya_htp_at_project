package webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class webDriver {
    public static WebDriver driver;
    public static WebDriver getChromeDriver(){ if (driver==null) {driver=new ChromeDriver();}
        return  driver;
    }
    public static WebDriver getFirefoxDriver(){if (driver==null)
    {driver=new FirefoxDriver();}
        return driver;
    }
    public static WebDriver getIEllDriver(){if (driver==null)
    {driver=new InternetExplorerDriver();}
        return driver;
    }
}
