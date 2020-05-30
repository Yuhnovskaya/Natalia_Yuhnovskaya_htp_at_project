package steps.httpTestSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import steps.bookingTestSteps.BookingSteps;
import testObject.httpTestObjects.ObjectBody;
import testObject.httpTestObjects.TestData;
import utilites.JSONparser;
import webDriver.Prop;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Properties;

public class HttpCucmberSteps {
    private ObjectBody actual;
    private static final Logger LOGGER = LogManager.getLogger(HttpCucmberSteps.class);
    @Given("I start execution httpTest")
    public void iStartExecutionHttpTest() {
    }

    @When("I search user by {int}")
    public void iSearchUserBy(Integer int1) throws IOException, URISyntaxException {
        MyHTTPClient myHTTPClient = new MyHTTPClient();
        Properties prop = Prop.getProp();
        TestData testData = JSONparser.parseTestData("src/test/resources/httpTestData").get(int1);
        Map<String, ObjectBody> actualMap = myHTTPClient.httpPost(prop.getProperty("URL_WEBSERVICE"), testData);
        actual = actualMap.entrySet().iterator().next().getValue();
    }

    @Then("I verify that I got {string}")
    public void iVerifyThatIGot(String string) throws IOException {
        ObjectBody expected = JSONparser.getExpectedData(string);
        Assert.assertTrue(CheckResult.checkResult(actual, expected));
    }
}
