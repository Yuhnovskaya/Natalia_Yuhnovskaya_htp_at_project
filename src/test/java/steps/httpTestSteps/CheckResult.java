package steps.httpTestSteps;



import testObject.httpTestObjects.User;
import testObject.httpTestObjects.ObjectBody;

import java.util.List;

public class CheckResult {
    public static boolean checkResult(ObjectBody actual, ObjectBody expected) {
        List<User> actualUsers = actual.getData();
        List<User> expectedUsers = expected.getData();
        for (int i = 0; i < actualUsers.size(); i++) {
            if (actualUsers.get(i).toString().equals(expectedUsers.get(i).toString()))
                return true;
        }
        return false;
    }
}
