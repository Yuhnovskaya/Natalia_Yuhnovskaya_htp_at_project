package runners.Cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import webDriver.Driver;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"steps.cucumber"},
        features = {"src/test/resources/features/silverscreen.feature"}
)

public class CinemaRun {
    @AfterClass
    public static void doAfterAll() {
        Driver.destroyDriver();
    }
}
