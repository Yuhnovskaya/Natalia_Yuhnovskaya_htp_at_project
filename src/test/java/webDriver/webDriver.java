package webDriver;

import org.openqa.selenium.WebDriver;

import java.sql.DriverManager;

public class webDriver {
        private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

        public static WebDriver getWebDriver(Config config) {
            if (webDriver.get() == null)
                webDriver.set(DrManager.getDriver(config));
            return webDriver.get();
        }
    }
