package runners.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.java.After;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import web_driver.Driver;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"steps.cucumber_steps.booking"},
        features = {"src/test/resources/features/headerElementsTest.feature",
                "src/test/resources/features/parisMoscowOsloBookingTest.feature",
                "src/test/resources/features/heartColorWishlistTest.feature",
                "src/test/resources/features/loginBookingTest.feature"
        }
)
public class BookingRun {
    @AfterClass
    public static void doAfterTest() {
        Driver.destroyDriver();
    }
}
