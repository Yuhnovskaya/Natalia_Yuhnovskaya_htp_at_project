package test_objects.http_test_objects;

public class ActualData {
    private static String instance;

    private ActualData() {
    }

    public static String getInstance() {
        if (instance == null) {
            instance = new String();
        }
        return instance;
    }
}

