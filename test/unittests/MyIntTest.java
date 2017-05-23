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
    public void test() {

    }

    @Test
    public void add() {
        MyInt d = new MyInt(6912);
        assertEquals(d.toString(), a.add(b).toString());
        d = new MyInt(-9134);
        assertEquals(d.toString(), x.add(y).toString());
        d = new MyInt(0);
        assertEquals(d.toString(), c.add(z).toString());
        d = new MyInt(1999);
        MyInt e = new MyInt(1);
        assertEquals("2000",d.add(e).toString());
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
        d = new MyInt("2000");
        MyInt e = new MyInt(1);
        MyInt f = new MyInt("1999");
        assertEquals(f.toString(), d.subtract(e).toString());
        d = new MyInt(Long.MAX_VALUE);
        d = d.add(new MyInt(5));
        d = d.subtract(new MyInt(6));
        assertEquals("9223372036854775806", d.toString());
    }

    @Test
    public void multiply() {
        MyInt d = new MyInt(7006652);
        assertEquals(d.toString(), a.multiply(b).toString());
        d = new MyInt(-2138640);
        assertEquals(d.toString(), c.multiply(x).toString());
        d = new MyInt(-38547942);
        assertEquals(d.toString(), y.multiply(b).toString());
        d = MyInt.ZERO;
        assertEquals(d.toString(), a.multiply(d).toString());
        d = MyInt.ONE;
        assertEquals(a.toString(), d.multiply(a).toString());
    }


    @Test
    public void gcd() {
        MyInt d = new MyInt(70);
        MyInt e = new MyInt(105);
        assertEquals("35", d.gcd(e).toString());
        d = new MyInt(-70);
        assertEquals("35", d.gcd(e).toString());
        d = new MyInt(1);
        assertEquals("1", d.gcd(e).toString());
        d = new MyInt("0");
        assertEquals("105", d.gcd(e).toString());
    }

    @Test
    public void longValue() {
        MyInt d = new MyInt(Long.MAX_VALUE);
        d = d.add(new MyInt(5));
        d = d.subtract(new MyInt(7));
        assertEquals(Long.MAX_VALUE - 2, d.longValue());
        d = new MyInt(Long.MIN_VALUE);
        d = d.subtract(new MyInt(2));
        d = d.add(new MyInt(3));
        assertEquals(Long.MIN_VALUE + 1, d.longValue());
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
