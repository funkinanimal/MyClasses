package unittests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyIntTest extends Assert{

    private MyInt a, b, c, z, x, y;

    @Before
    public void Before() {
        a = new MyInt(1234);
        b = new MyInt("5678");
        c = new MyInt(new byte[] {0, 9, 1, 2});
        z = new MyInt(1234);
        y = new MyInt("5678");
        x = new MyInt(new byte[] {0, 9, 1, 2});
    }

    @Test
    public void isGreater() {
        assertEquals(true, y.isGreater(a));
        assertEquals(false, x.isGreater(a));
    }

    @Test
    public void add() throws Exception {
        MyInt d = new MyInt(2468);
        assertEquals(d.toString(), a.add(z).toString());
        d = new MyInt(11356);
        assertEquals(d.toString(), b.add(y).toString());
        d = new MyInt(1824);
        assertEquals(d.toString(), c.add(x).toString());
    }

    @Test
    public void max()
    {

    }

    @Test
    public void subtract() {
        MyInt d = new MyInt(0);
        assertEquals(true, d.compareTo(a.subtract(a)));
        d = new MyInt(-4444);
        assertEquals(true, d.compareTo(a.subtract(b)));
        d = new MyInt(4766);
        assertEquals(true, d.compareTo(b.subtract(c)));
        d = new MyInt(-322);
        assertEquals(d.toString(), c.subtract(a).toString());
        d = new MyInt(4444);
        assertEquals(true, d.compareTo(b.subtract(a)));
    }

    @Test
    public void divide() throws Exception {
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
        MyInt d = new MyInt("912");
        assertEquals(true, d.compareTo(c));
    }

    /*@Test
    public void gcd() throws Exception {
    }*/

    @Test
    public void ToString() throws Exception {
        assertEquals("1234", a.toString());
        assertEquals("5678", b.toString());
        assertEquals("912", c.toString());
    }

    @Test
    public void longValue() throws Exception {
    }

}