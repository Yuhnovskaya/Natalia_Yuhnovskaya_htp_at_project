package test_objects.http_test_objects;

public class ExpectedData {
    private static String instance;

    private ExpectedData() {

    }

    public static String getInstance() {
        if (instance == null) {
            instance = new String();
        }
        return instance;
    }
}
