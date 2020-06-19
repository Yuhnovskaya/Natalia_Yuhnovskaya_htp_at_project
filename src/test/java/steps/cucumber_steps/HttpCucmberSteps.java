package steps.cucumber_steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import steps.http_test_steps.MyHTTPClient;
import test_objects.http_test_objects.TestData;
import utilites.JSONparser;

import java.io.IOException;
import java.net.URISyntaxException;

public class HttpCucmberSteps {
    static MyHTTPClient myHTTPClient = new MyHTTPClient();
    private static final String URL = "http://178.124.206.46:8001/app/ws/";
    private static final Logger LOGGER = LogManager.getLogger(HttpCucmberSteps.class);
    private static String actualData;
    @Given("^I start execution httpTest$")
    public void iStartExecutionHttpTest() {

    }

    @When("I search user by {int}")
    public void iSearchUserBy(Integer caseNumber) throws IOException, URISyntaxException {
        TestData testData = JSONparser.parseTestData("src/test/resources/httpTestData").get(caseNumber);
        String actualObjectBody = myHTTPClient.httpPost(URL, testData);
        actualData= JSONparser.parseActualData(actualObjectBody);
    }

    @Then("I verify that I got {string}")
    public void iVerifyThatIGot(String pathToExpectedData) throws IOException {
        String expectedData = JSONparser.getExpectedData(pathToExpectedData);
        Assert.assertTrue(actualData.equals(expectedData));
    }
}
