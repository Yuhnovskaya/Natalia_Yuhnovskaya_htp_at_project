package runners.Junit;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.SearchTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({SearchTest.class})
public class JUnitRunner {
}
