package runners.Cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"steps.bookingTestSteps"},
        features = {"src/test/resources/features/verifyHeartColorWishlistTest.feature"
        },
        monochrome = false,
        snippets = SnippetType.CAMELCASE,
        strict = false)
public class VerifyHeartColorWishlistCucumberRun {
}
