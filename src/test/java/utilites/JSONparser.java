package utilites;


import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import testObject.Search;
import testObject.ObjectBody;
import testObject.TestData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class JSONparser {
    static Gson gson = new Gson();

    public static String fromGson(TestData testData) {
        return gson.toJson(testData);
    }
    public static File fileToParse(String path) {
        String JSON = Paths.get(path).toString();
        File file = new File(JSON);
        return file;
    }
    public static ObjectBody getExpectedData(String path) throws IOException {
        File pathToJson =fileToParse(path);
        ObjectBody expectedData = gson.fromJson(new JsonReader(new FileReader(pathToJson)),
                ObjectBody.class);
        return expectedData;
    }
    public static ObjectBody parseActualData(String json) {
            return gson.fromJson(json, ObjectBody.class);
        }

        public static List<TestData> parseTestData(String path) throws FileNotFoundException {
       File pathToJson=fileToParse(path);
        Search testData=gson.fromJson(new JsonReader(new FileReader(pathToJson)), Search.class);
        List<TestData> SearchTestData=testData.getTestData();
        return SearchTestData;
        }
}

