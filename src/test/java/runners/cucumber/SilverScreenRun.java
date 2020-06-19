package runners.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import web_driver.Driver;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"steps.cucumber_steps"},
        features = {"src/test/resources/features/silverscreen.feature"}
)

public class SilverScreenRun {
    @AfterClass
    public static void doAfterAll() {
        Driver.destroyDriver();
    }
}
