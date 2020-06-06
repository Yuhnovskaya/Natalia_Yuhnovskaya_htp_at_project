package runners.Cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import webDriver.Config;
import webDriver.DrManager;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"steps.cucumber"},
        features = {"src/test/resources/features/cinema.feature"},
        monochrome = false,
        snippets = SnippetType.CAMELCASE,
        strict = false)

public class CinemaRun {




}
