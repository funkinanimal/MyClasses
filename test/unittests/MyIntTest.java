package unittests;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Keshman on 11.05.2017.
 */
public class MyIntTest {

    private static MyInt a, b, c;

    @BeforeClass
    public static void beforeClass() {
        a = new MyInt(1234);
        b = new MyInt("5678");
        c = new MyInt(new byte[] {9, 0, 1, 2});
    }

    @Test
    public void add() throws Exception {
        assertEquals(6912, a.add(b));
        assertEquals(14690, b.add(c));
        assertEquals(10246, a.add(c));
    }

    @Test
    public void subtract() throws Exception {
        assertEquals(-4444, a.subtract(b));
        assertEquals(-3334, b.subtract(c));
        assertEquals(-7778, a.subtract(c));
    }

    @Test
    public void divide() throws Exception {
    }

    @Test
    public void max() throws Exception {
    }

    @Test
    public void min() throws Exception {
    }

    @Test
    public void abs() throws Exception {
    }

    @Test
    public void compareTo() throws Exception {
        assertEquals(false, a.compareTo(b));
        MyInt d = new MyInt("9012");
        assertEquals(true, d.compareTo(c));
    }

    /*@Test
    public void gcd() throws Exception {
    }*/

    @Test
    public void ToString() throws Exception {
        assertEquals("1234", a.ToString());
        assertEquals("5678", b.ToString());
        assertEquals("9012", c.ToString());
    }

    @Test
    public void longValue() throws Exception {
    }

}