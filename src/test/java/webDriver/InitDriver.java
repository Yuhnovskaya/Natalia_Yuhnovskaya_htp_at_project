package webDriver;

import org.openqa.selenium.WebDriver;

public class InitDriver {
    
    public void initDriver(Config config){
            DrManager.getDriver(config);
    }
}
