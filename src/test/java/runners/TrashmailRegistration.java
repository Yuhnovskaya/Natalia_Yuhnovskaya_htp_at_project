package runners;

import org.openqa.selenium.WebDriver;
import steps.bookingTestSteps.TrashMailSteps;
import webDriver.Prop;
import webDriver.Config;
import webDriver.DrManager;

import java.util.Properties;

public class TrashmailRegistration {
    public static WebDriver driver;

    public static void main(String[] avgs) throws InterruptedException {
        driver = DrManager.getDriver(Config.CHROME);
        Properties prop = Prop.getProp();
        TrashMailSteps trashMailSteps = new TrashMailSteps();
        trashMailSteps.trashmailRegistration(driver);
    }
}