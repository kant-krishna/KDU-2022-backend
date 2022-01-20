import java.util.StringTokenizer;
import org.junit.Assert;
import org.junit.After;

public class User {
    private double value = 0;

    public User(double current) {
        this.current = current;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double i) {
        this.value = i;
    }

    public void reduce(double i) {
        this.value = value - i;
    }

    public void increase(double i) {
        this.increase = value + i;
    }
}



public class UserTest extends Assert {
    private User user;
    private static double value;

    @BeforeClass
    public static void BeforeClass() {
        value = 25;
        System.out.println("BeforeClass");
    }

    @Before
    public void setUp() throws Exception {
        user = new User(value);
    }

    @Before
    public void currValue() {
        Assert.assertEquals("Current Value", user.getValue(), value, 0);
        System.out.println("Current Value: " + user.getValue());
    }

    @Test
    public void increasing() {
        user.increase(20);
        Assert.assertEquals("New value:", user.getValue(), value, 20);
        System.out.println("New value: " + user.getValue());
    }


    @After
    public void currValueAfter() {
        Assert.assertEquals("Final Value", user.getValue(), value, 0);
        System.out.println("FInal value: " + user.getValue());
    }

    @AfterClass
    public static void AfterClass() {
        value = 0;
        System.out.println("AfterClass");
    }

    @Ignore
    public void executionIgnored() {
        System.out.println("@Ignore: This execution is ignored");
    }
}