package tests;


import httpService.MyHTTPClient;
import org.junit.Assert;
import org.junit.Test;
import otherStuff.CheckResult;
import testObject.Search;
import testObject.TestData;
import utilites.JSONparser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;


public class searchTest {
    static MyHTTPClient myHTTPClient = new MyHTTPClient();
   /* public static void main(String[]avgs) throws IOException, URISyntaxException {
        Search search = new Search("", false);
        myHTTPClient.httpPost(search);
    }*/

  @Test
  public void allUsers() throws IOException, URISyntaxException {

        Search search = new Search("", false);
        Map<String, TestData> actualMap=myHTTPClient.httpPost(search);
        TestData actual=actualMap.entrySet().iterator().next().getValue();
        TestData expected= JSONparser.getExpectedData("src/test/resources/EspectedData/allUsers");
Assert.assertTrue(CheckResult.checkResult(actual,expected));
    }

    @Test
    public void shotFullName() throws IOException, URISyntaxException {
        Search search = new Search("a", true);
        Map<String,TestData> actualMap=myHTTPClient.httpPost(search);
        TestData actual=actualMap.entrySet().iterator().next().getValue();
        TestData expected=JSONparser.getExpectedData("src/test/resources/EspectedData/shortFullName");
        Assert.assertTrue(CheckResult.checkResult(actual,expected));
    }

    @Test
    public void shotPortionName() throws IOException, URISyntaxException {
        Search search = new Search("a", false);
        Map<String,TestData> actualMap=myHTTPClient.httpPost(search);
        TestData actual=actualMap.entrySet().iterator().next().getValue();
        TestData expected=JSONparser.getExpectedData("src/test/resources/EspectedData/shortPartialName");
        Assert.assertTrue(CheckResult.checkResult(actual,expected));
    }

    @Test
    public void longFullName() throws IOException, URISyntaxException {
        Search search = new Search("rangaradjangoo", false);
        Map<String,TestData> actualMap=myHTTPClient.httpPost(search);
        TestData actual=actualMap.entrySet().iterator().next().getValue();
        TestData expected=JSONparser.getExpectedData("src/test/resources/EspectedData/longFullName");
        Assert.assertTrue(CheckResult.checkResult(actual,expected));
    }

    @Test
    public void longPortionName() throws IOException, URISyntaxException {
        Search search = new Search("rangaradjangoo", false);
        Map<String,TestData> actualMap=myHTTPClient.httpPost(search);
        TestData actual=actualMap.entrySet().iterator().next().getValue();
        TestData expected=JSONparser.getExpectedData("src/test/resources/EspectedData/longPartialName");
        Assert.assertTrue(CheckResult.checkResult(actual,expected));
    }
}

