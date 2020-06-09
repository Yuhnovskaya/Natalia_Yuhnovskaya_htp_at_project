package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver initDriver(Config config) {
        if (webDriver.get() == null)
            webDriver.set(DrManager.getDriver(config));
        return webDriver.get();
    }

    public static void destroyDriver() {
        webDriver.get().close();
        webDriver.get().quit();
    }

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    public static void windowMaxSize() {
        webDriver.get()
                .manage()
                .window()
                .maximize();
    }

    public static void getURL(String url) {
        webDriver.get()
                .get(url);
    }

    public static void goBack() {
        webDriver.get()
                .navigate()
                .back();
    }

  /*  public static void deleteCookies() {
        webDriver.get().manage().deleteAllCookies();
    }*/

    public static void clearCache() throws InterruptedException {
        webDriver.get().manage().deleteAllCookies();
        webDriver.get().get("chrome://settings/clearBrowserData");
        webDriver.get().findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
    }
}
