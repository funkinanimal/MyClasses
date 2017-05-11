package unittests;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Keshman on 11.05.2017.
 */
public class MyIntTest {

    private MyInt a, b, c;

    @BeforeClass
    public void beforeClass() {
        a = new MyInt(1234);
        b = new MyInt("5678");
        c = new MyInt(new byte[] {9, 0, 1, 2});
    }

    @Test
    public void add() throws Exception {
    }

    @Test
    public void subtract() throws Exception {
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

    @Test
    public void gcd() throws Exception {
    }

    @Test
    public void ToString() throws Exception {
        assertEquals("1234", a.ToString());
        assertEquals("5678", b.toString());
        assertEquals("9012", c.toString());
    }

    @Test
    public void longValue() throws Exception {
    }

}