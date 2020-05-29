package steps.httpTestSteps;



import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import steps.bookingTestSteps.BookingSteps;
import testObject.httpTestObjects.User;
import testObject.httpTestObjects.ObjectBody;

import java.util.List;

public class CheckResult {
    private static final Logger LOGGER = LogManager.getLogger(CheckResult.class);
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
