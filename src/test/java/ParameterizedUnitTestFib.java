import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static junit.framework.TestCase.assertEquals;
@RunWith(Parameterized.class)
public class ParameterizedUnitTestFib {


    @Parameterized.Parameter(0)
    public int sInput;
    @Parameterized.Parameter(1)
    public int wExpected;
    @Parameterized.Parameters(name = "index}: stairs: {0}= output :{1}")
    public static Iterable<Object[]> data() {

// testing with input values 0,1,2,3,4,5,-3
        return Arrays.asList(new Object[][]{{0, 0}, {1, 1}, {2, 1},
             {3, 2}, {4, 3}, {5, 5}, {-3, -3}});

       }
    @Test
    public void testCountWays() {
/* assume making a GET request to http://localhost/staircase/stairs/n with
input value n (no.of stairs).
and validating against GET response*/
        Stairs stairs = new Stairs();
        assertEquals(wExpected, stairs.fib(sInput));
    }

}
