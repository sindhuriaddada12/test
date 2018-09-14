import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunnerTests {
    public static void main(String[] args) {
// runs Unit and functional tests
        Result result =
                JUnitCore.runClasses(ParameterizedCountWaysTest.class, IntegrationTests.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());

    }
}