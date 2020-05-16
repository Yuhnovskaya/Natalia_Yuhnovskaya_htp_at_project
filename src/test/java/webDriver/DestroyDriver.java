package webDriver;

import org.openqa.selenium.WebDriver;

public class DestroyDriver {
     public static void destroy(WebDriver driver){
        driver.close();
        driver.quit();
        driver=null;
    }
}
