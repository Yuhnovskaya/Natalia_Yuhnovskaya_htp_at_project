package runners.Junit;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.searchTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({searchTest.class})
public class JUnitRunner {
}
