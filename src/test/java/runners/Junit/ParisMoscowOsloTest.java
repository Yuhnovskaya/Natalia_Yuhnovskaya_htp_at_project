package runners.Junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.WebDriver;
import tests.VerifyAddressColorOsloTest;
import tests.VerifyPriceMoscowTest;
import tests.VerifyPriceParisTest;
import webDriver.Config;
import webDriver.DestroyDriver;
import webDriver.DrManager;
import webDriver.Prop;

import java.util.Properties;

@RunWith(Suite.class)
@Suite.SuiteClasses({VerifyPriceParisTest.class, VerifyPriceMoscowTest.class, VerifyAddressColorOsloTest.class})
public class ParisMoscowOsloTest {
    static Properties prop = Prop.getProp();
    static WebDriver driver= DrManager.getDriver(Config.CHROME);
    @BeforeClass
    public static void doBefore() throws InterruptedException {
        driver.get(prop.getProperty("URL_BOOKING"));
    }
 @AfterClass
    public static void doafter(){
        DestroyDriver.destroy(driver);
    }
}
