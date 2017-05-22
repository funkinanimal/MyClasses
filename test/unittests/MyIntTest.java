package unittests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyIntTest extends Assert{

    private MyInt a, b, c, x, y, z;

    @Before
    public void Before() {
        a = new MyInt(1234);
        b = new MyInt("5678");
        c = new MyInt(new byte[] {0, 9, 1, 2});
        x = new MyInt(-2345);
        y = new MyInt("-6789");
        z = new MyInt(new byte[] {1, 9, 1, 2});
    }


    @Test
    public void add() {
        MyInt d = new MyInt(6912);
        assertEquals(d.toString(), a.add(b).toString());
        d = new MyInt(-9134);
        assertEquals(d.toString(), x.add(y).toString());
        d = new MyInt(0);
        assertEquals(d.toString(), c.add(z).toString());
    }

    @Test
    public void subtract() {
        MyInt d = new MyInt(-4444);
        assertEquals(d.toString(), a.subtract(b).toString());
        d = new MyInt(-9134);
        assertEquals(d.toString(), x.subtract(y).toString());
        d = new MyInt(8023);
        assertEquals(d.toString(), b.subtract(x).toString());
        d = new MyInt(-8023);
        assertEquals(d.toString(), y.subtract(a).toString());
        d = new MyInt(0);
        assertEquals(d.toString(), a.subtract(a).toString());
    }

    @Test
    public void max() {
        assertEquals(b.toString(), MyInt.max(a, b).toString());
        assertEquals(c.toString(), MyInt.max(c, z).toString());
    }

    @Test
    public void min() {
        assertEquals(a.toString(), MyInt.min(a, b).toString());
        assertEquals(z.toString(), MyInt.min(c, z).toString());
    }

    @Test
    public void abs() {
        MyInt d = new MyInt(2345);
        assertEquals(d.toString(), MyInt.abs(x).toString());
        d = new MyInt(0);
        assertEquals(d.toString(), MyInt.abs(d).toString());
        assertEquals(a.toString(), MyInt.abs(a).toString());
    }


    @Test
    public void compareTo() {
        assertEquals(true, a.compareTo(b) < 0);
        assertEquals(true, z.compareTo(c) < 0);
        assertEquals(true, b.compareTo(z) > 0);
    }

    @Test
    public void ToString() {
        assertEquals("1234", a.toString());
        assertEquals("5678", b.toString());
        assertEquals("912", c.toString());
        assertEquals("-2345", x.toString());
        assertEquals("-6789", y.toString());
        assertEquals("-912", z.toString());
    }


}