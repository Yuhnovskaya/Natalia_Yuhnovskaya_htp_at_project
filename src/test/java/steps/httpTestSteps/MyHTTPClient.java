package steps.httpTestSteps;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import steps.bookingTestSteps.BookingSteps;
import testObject.httpTestObjects.ObjectBody;
import testObject.httpTestObjects.TestData;
import utilites.JSONparser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class MyHTTPClient {
    private static final Logger LOGGER = LogManager.getLogger(MyHTTPClient.class);
    public void httpGet() throws IOException,  URISyntaxException {
    HttpClient client= HttpClientBuilder.create().build();
    URIBuilder builder=new URIBuilder("http://178.124.206.46:8001/app/ws/");
    HttpGet request=new HttpGet(builder.build());
    HttpResponse response=client.execute(request);
    System.out.println(EntityUtils.toString(response.getEntity()));
}
  public static Map<String, ObjectBody> httpPost(String url, TestData testData)throws IOException,  URISyntaxException {
    HttpClient client= HttpClientBuilder.create().build();
        URIBuilder builder=new URIBuilder(url);
        HttpPost request=new HttpPost(builder.build());
        request.setEntity(new StringEntity(JSONparser.fromGson(testData)));
        HttpResponse response=client.execute(request);
     Map<String, ObjectBody> responseMap=new HashMap();
        String code=String.valueOf(response.getStatusLine().getStatusCode());
        responseMap.put(code,JSONparser.parseActualData(EntityUtils.toString(response.getEntity())));
   return responseMap;
    }
}

