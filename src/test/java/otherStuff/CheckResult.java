package otherStuff;



import testObject.Data;
import testObject.TestData;

import java.util.List;

public class CheckResult {
    public static boolean checkResult(TestData actual, TestData expected) {
        List<Data> actualUsers = actual.getData();
        List<Data> expectedUsers = expected.getData();
        for (int i = 0; i < actualUsers.size(); i++) {
            if (actualUsers.get(i).toString().equals(expectedUsers.get(i).toString()))
                return true;
        }
        return false;
    }
}
//request