package runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;
import org.openqa.selenium.WebDriver;
import tests.VerifyAddressColorOslo;
import tests.VerifyPriceMoscow;
import tests.VerifyPriceParis;
import webDriver.Config;
import webDriver.DestroyDriver;
import webDriver.DrManager;
import webDriver.Prop;

import java.util.Properties;

@RunWith(Suite.class)
@Suite.SuiteClasses({VerifyPriceParis.class, VerifyPriceMoscow.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
