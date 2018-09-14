import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StairsUnitTest {
    @Before
    public void setUp(){
        Stairs stairs = new Stairs();
    }
    @Test
    public void testfib() {
        Stairs stairs = new Stairs();
        int ways = stairs.fib(3);
        assertEquals(2, ways);
    }
    @Test
    public void testcountWays(){
        Stairs stairs = new Stairs();
        int countWays = stairs.countWays(4);
        assertEquals(5, countWays);
    }
    @Test
    public void testConditionValue1(){
        Stairs stairs = new Stairs();
        int countWays = stairs.countWays(1);
        assertEquals(1, countWays);
    }
    @Test
    public void testConditionValue0(){
        Stairs stairs = new Stairs();

        int countWays = stairs.countWays(0);
        assertEquals(1, countWays);
    }
}
