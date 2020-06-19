package runners.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"steps", "steps.gui", "steps.api"},
        features = {"src\\test\\resources\\features\\usersApiTest.feature"
        },
        monochrome = false,
        snippets = SnippetType.CAMELCASE,
        strict = false)

public class CucumberRun {

}
