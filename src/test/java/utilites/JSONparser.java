package utilites;


import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import test_objects.booking_test_objects.BookingTestCase;
import test_objects.booking_test_objects.BookingTestData;
import test_objects.http_test_objects.Search;
import test_objects.http_test_objects.ObjectBody;
import test_objects.http_test_objects.TestData;

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

    public static String getExpectedData(String path) throws IOException {
        File pathToJson = fileToParse(path);
        String expectedData = JSONparser.objectToString(gson.fromJson(new JsonReader(new FileReader(pathToJson)),
                ObjectBody.class));
        return expectedData;
    }

    public static String objectToString(ObjectBody objectBody) {
        return gson.toJson(objectBody);
    }

    public static String parseActualData(String json) {
        return gson.toJson(gson.fromJson(json, ObjectBody.class));
    }

    public static List<TestData> parseTestData(String path) throws FileNotFoundException {
        File pathToJson = fileToParse(path);
        Search testData = gson.fromJson(new JsonReader(new FileReader(pathToJson)), Search.class);
        List<TestData> SearchTestData = testData.getTestData();
        return SearchTestData;
    }

    public static List<BookingTestCase> getBookingTestCase(String path) throws FileNotFoundException {
        File pathToJSON = fileToParse(path);
        BookingTestData bookingTestData = gson.fromJson(new JsonReader(new FileReader(pathToJSON)), BookingTestData.class);
        List<BookingTestCase> bookingTestCase = bookingTestData.getBookingTestCase();
        return bookingTestCase;
    }
}

