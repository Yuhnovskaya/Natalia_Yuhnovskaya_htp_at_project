package runners.junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.AddressColorOsloTest;
import tests.PriceMoscowTest;
import tests.PriceParisTest;

import web_driver.*;


@RunWith(Suite.class)
@Suite.SuiteClasses({PriceParisTest.class, PriceMoscowTest.class, AddressColorOsloTest.class})
public class ParisMoscowOsloTest {
    @BeforeClass
    public static void doBeforeClass() {
        Driver.initDriver(Config.CHROME);
    }
    @AfterClass
    public static void doAfterClass() {
        Driver.destroyDriver();
    }
}
