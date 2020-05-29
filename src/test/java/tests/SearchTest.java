package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import steps.httpTestSteps.MyHTTPClient;
import org.junit.Assert;
import org.junit.Test;
import steps.httpTestSteps.CheckResult;
import testObject.httpTestObjects.ObjectBody;
import testObject.httpTestObjects.TestData;
import utilites.JSONparser;
import webDriver.Prop;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Properties;


public class SearchTest {
    static MyHTTPClient myHTTPClient = new MyHTTPClient();
    static Properties prop = Prop.getProp();
    private static final Logger LOGGER = LogManager.getLogger(SearchTest.class);

    @Before
    public void beforeSearchTestInfo() {
        LOGGER.info("SearchTest started running");
    }

    @Test
    public void allUsers() throws IOException, URISyntaxException {

        TestData testData = JSONparser.parseTestData("src/test/resources/httpTestData").get(0);
        Map<String, ObjectBody> actualMap = myHTTPClient.httpPost(prop.getProperty("URL_WEBSERVICE"), testData);
        ObjectBody actual = actualMap.entrySet().iterator().next().getValue();
        ObjectBody expected = JSONparser.getExpectedData("src/test/resources/httpExpectedData/allUsers");
        Assert.assertTrue(CheckResult.checkResult(actual, expected));
    }

    @Test
    public void shotFullName() throws IOException, URISyntaxException {
        TestData testData = JSONparser.parseTestData("src/test/resources/httpTestData").get(1);
        Map<String, ObjectBody> actualMap = myHTTPClient.httpPost(prop.getProperty("URL_WEBSERVICE"), testData);
        ObjectBody actual = actualMap.entrySet().iterator().next().getValue();
        ObjectBody expected = JSONparser.getExpectedData("src/test/resources/httpExpectedData/shortFullName");
        Assert.assertTrue(CheckResult.checkResult(actual, expected));
    }

    @Test
    public void shotPartialName() throws IOException, URISyntaxException {
        TestData testData = JSONparser.parseTestData("src/test/resources/httpTestData").get(2);
        Map<String, ObjectBody> actualMap = myHTTPClient.httpPost(prop.getProperty("URL_WEBSERVICE"), testData);
        ObjectBody actual = actualMap.entrySet().iterator().next().getValue();
        ObjectBody expected = JSONparser.getExpectedData("src/test/resources/httpExpectedData/shortPartialName");
        Assert.assertTrue(CheckResult.checkResult(actual, expected));
    }

    @Test
    public void longFullName() throws IOException, URISyntaxException {
        TestData testData = JSONparser.parseTestData("src/test/resources/httpTestData").get(3);
        Map<String, ObjectBody> actualMap = myHTTPClient.httpPost(prop.getProperty("URL_WEBSERVICE"), testData);
        ObjectBody actual = actualMap.entrySet().iterator().next().getValue();
        ObjectBody expected = JSONparser.getExpectedData("src/test/resources/httpExpectedData/longFullName");
        Assert.assertTrue(CheckResult.checkResult(actual, expected));
    }

    @Test
    public void longPartialName() throws IOException, URISyntaxException {
        TestData testData = JSONparser.parseTestData("src/test/resources/httpTestData").get(4);
        Map<String, ObjectBody> actualMap = myHTTPClient.httpPost(prop.getProperty("URL_WEBSERVICE"), testData);
        ObjectBody actual = actualMap.entrySet().iterator().next().getValue();
        ObjectBody expected = JSONparser.getExpectedData("src/test/resources/httpExpectedData/longPartialName");
        Assert.assertTrue(CheckResult.checkResult(actual, expected));
    }

    @After
    public void afterSearchTestInfo() {
        LOGGER.info("SearchTest is finfshed");
    }
}

