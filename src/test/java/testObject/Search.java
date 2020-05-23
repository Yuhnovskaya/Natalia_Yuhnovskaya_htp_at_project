package testObject;

import java.util.List;

public class Search {
    List<TestData> testData;


    public Search(List<TestData> testData) {
        this.testData = testData;
    }

    public List<TestData> getTestData() {
        return testData;
    }
}
