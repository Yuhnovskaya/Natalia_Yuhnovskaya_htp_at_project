package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import steps.http_test_steps.MyHTTPClient;
import org.junit.Assert;
import org.junit.Test;
import test_objects.http_test_objects.TestData;
import utilites.JSONparser;

import java.io.IOException;
import java.net.URISyntaxException;


public class SearchTest {
    static MyHTTPClient myHTTPClient = new MyHTTPClient();
    private static final String URL = "http://178.124.206.46:8001/app/ws/";
    private static final Logger LOGGER = LogManager.getLogger(SearchTest.class);

    @Before
    public void beforeSearchTestInfo() {
        LOGGER.info("SearchTest started running");
    }

    @Test
    public void allUsers() throws IOException, URISyntaxException {

        TestData testData = JSONparser.parseTestData("src/test/resources/httpTestData").get(0);
        String actualObjectBody = myHTTPClient.httpPost(URL, testData);
        String expectedData = JSONparser.getExpectedData("src/test/resources/http_expected_data/allUsers");
        String actualData = JSONparser.parseActualData(actualObjectBody);
        Assert.assertTrue(actualData.equals(expectedData));
    }

    @Test
    public void shotFullName() throws IOException, URISyntaxException {
        TestData testData = JSONparser.parseTestData("src/test/resources/httpTestData").get(1);
        String actualObjectBody = myHTTPClient.httpPost(URL, testData);
        String expectedData = JSONparser.getExpectedData("src/test/resources/http_expected_data/shortFullName");
        String actualData = JSONparser.parseActualData(actualObjectBody);
        Assert.assertTrue(actualData.equals(expectedData));
    }

    @Test
    public void shotPartialName() throws IOException, URISyntaxException {
        TestData testData = JSONparser.parseTestData("src/test/resources/httpTestData").get(2);
        String actualObjectBody = myHTTPClient.httpPost(URL, testData);
        String expectedData = JSONparser.getExpectedData("src/test/resources/http_expected_data/shortPartialName");
        String actualData = JSONparser.parseActualData(actualObjectBody);
        Assert.assertTrue(actualData.equals(expectedData));
    }

    @Test
    public void longFullName() throws IOException, URISyntaxException {
        TestData testData = JSONparser.parseTestData("src/test/resources/httpTestData").get(3);
        String actualObjectBody = myHTTPClient.httpPost(URL, testData);
        String expectedData = JSONparser.getExpectedData("src/test/resources/http_expected_data/longFullName");
        String actualData = JSONparser.parseActualData(actualObjectBody);
        Assert.assertTrue(actualData.equals(expectedData));
    }

    @Test
    public void longPartialName() throws IOException, URISyntaxException {
        TestData testData = JSONparser.parseTestData("src/test/resources/httpTestData").get(4);
        String actualObjectBody = myHTTPClient.httpPost(URL, testData);
        String expectedData = JSONparser.getExpectedData("src/test/resources/http_expected_data/longPartialName");
        String actualData = JSONparser.parseActualData(actualObjectBody);
        Assert.assertTrue(actualData.equals(expectedData));
    }

    @After
    public void afterSearchTestInfo() {
        LOGGER.info("SearchTest is finfshed");
    }
}

