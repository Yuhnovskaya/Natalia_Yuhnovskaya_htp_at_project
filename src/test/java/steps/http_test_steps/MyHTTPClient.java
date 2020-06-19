package steps.http_test_steps;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import test_objects.http_test_objects.TestData;
import utilites.JSONparser;

import java.io.IOException;
import java.net.URISyntaxException;

public class MyHTTPClient {
  public static String httpPost(String url, TestData testData)throws IOException,  URISyntaxException {
    HttpClient client= HttpClientBuilder.create().build();
        URIBuilder builder=new URIBuilder(url);
        HttpPost request=new HttpPost(builder.build());
        request.setEntity(new StringEntity(JSONparser.fromGson(testData)));
        HttpResponse response=client.execute(request);
   return EntityUtils.toString(response.getEntity());
    }
}
