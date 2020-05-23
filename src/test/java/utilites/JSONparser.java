package utilites;


import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import testObject.Search;
import testObject.TestData;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class JSONparser {
    static Gson gson = new Gson();

    public static String fromGson(Search search) {
        return gson.toJson(search);
    }
    public static File ExspectedDataFile(String path) {
        String JSON = Paths.get(path).toString();
        File file = new File(JSON);
        return file;
    }
    public static TestData getExpectedData(String path) throws IOException {
        File pathToJson =ExspectedDataFile(path);
        TestData expectedData = gson.fromJson(new JsonReader(new FileReader(pathToJson)),
                TestData.class);
        return expectedData;
    }
    public static TestData parseActualData(String json) {
            return gson.fromJson(json, TestData.class);
        }

}
//request
