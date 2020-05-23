package tests;

import httpService.MyHTTPClient;
import org.junit.Assert;
import org.junit.Test;
import otherStuff.CheckResult;
import testObject.ObjectBody;
import testObject.TestData;
import utilites.JSONparser;
import webDriver.Prop;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Properties;


public class searchTest {
    static MyHTTPClient myHTTPClient = new MyHTTPClient();
    static Properties prop = Prop.getProp();
  @Test
  public void allUsers() throws IOException, URISyntaxException {

        TestData testData =JSONparser.parseTestData("src/test/resources/testDataHttp").get(0);
        Map<String, ObjectBody> actualMap=myHTTPClient.httpPost(prop.getProperty("URL_WEBSERVICE"), testData);
        ObjectBody actual=actualMap.entrySet().iterator().next().getValue();
        ObjectBody expected= JSONparser.getExpectedData("src/test/resources/EspectedData/allUsers");
Assert.assertTrue(CheckResult.checkResult(actual,expected));
    }

  @Test
    public void shotFullName() throws IOException, URISyntaxException {
         TestData testData =JSONparser.parseTestData("src/test/resources/testDataHttp").get(1);
        Map<String, ObjectBody> actualMap=myHTTPClient.httpPost(prop.getProperty("URL_WEBSERVICE"),testData);
        ObjectBody actual=actualMap.entrySet().iterator().next().getValue();
        ObjectBody expected=JSONparser.getExpectedData("src/test/resources/EspectedData/shortFullName");
        Assert.assertTrue(CheckResult.checkResult(actual,expected));
    }

    @Test
    public void shotPartialName() throws IOException, URISyntaxException {
        TestData testData =JSONparser.parseTestData("src/test/resources/testDataHttp").get(2);
        Map<String, ObjectBody> actualMap=myHTTPClient.httpPost(prop.getProperty("URL_WEBSERVICE"),testData);
        ObjectBody actual=actualMap.entrySet().iterator().next().getValue();
        ObjectBody expected=JSONparser.getExpectedData("src/test/resources/EspectedData/shortPartialName");
        Assert.assertTrue(CheckResult.checkResult(actual,expected));
    }

    @Test
    public void longFullName() throws IOException, URISyntaxException {
        TestData testData =JSONparser.parseTestData("src/test/resources/testDataHttp").get(3);
        Map<String, ObjectBody> actualMap=myHTTPClient.httpPost(prop.getProperty("URL_WEBSERVICE"),testData);
        ObjectBody actual=actualMap.entrySet().iterator().next().getValue();
        ObjectBody expected=JSONparser.getExpectedData("src/test/resources/EspectedData/longFullName");
        Assert.assertTrue(CheckResult.checkResult(actual,expected));
    }

    @Test
    public void longPartialName() throws IOException, URISyntaxException {
        TestData testData =JSONparser.parseTestData("src/test/resources/testDataHttp").get(4);
        Map<String, ObjectBody> actualMap=myHTTPClient.httpPost(prop.getProperty("URL_WEBSERVICE"),testData);
        ObjectBody actual=actualMap.entrySet().iterator().next().getValue();
        ObjectBody expected=JSONparser.getExpectedData("src/test/resources/EspectedData/longPartialName");
        Assert.assertTrue(CheckResult.checkResult(actual,expected));
    }
}

