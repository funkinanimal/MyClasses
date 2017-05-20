package unittests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DEQueueTest extends Assert {

    private DEQueue<String> stringDEQueue;
    private DEQueue<Integer> integerDEQueue;

    @Before
    public void BeforeTest()
    {
        stringDEQueue = new DEQueue<>();
        integerDEQueue = new DEQueue<>();
    }

    @After
    public void AfterTest()
    {
        stringDEQueue.clear();
        integerDEQueue.clear();
    }

    @Test
    public void pushBack() {
        stringDEQueue.pushBack("test");
        assertEquals(1, stringDEQueue.size());
        assertEquals("test", stringDEQueue.front());
        stringDEQueue.pushBack("root");
        assertEquals("root", stringDEQueue.back());
        assertEquals(2, stringDEQueue.size());
    }

    @Test
    public void pushFront() {
        stringDEQueue.pushFront("test");
        assertEquals(1, stringDEQueue.size());
        assertEquals("test", stringDEQueue.back());
        stringDEQueue.pushFront("root");
        assertEquals("root", stringDEQueue.front());
        assertEquals(2, stringDEQueue.size());
    }

    @Test
    public void popBack() {
        integerDEQueue.pushFront(123);
        integerDEQueue.pushBack(456);
        integerDEQueue.popBack();
        assertEquals(Integer.valueOf(123), integerDEQueue.back());
        integerDEQueue.popBack();
        assertEquals(null, integerDEQueue.back());
        integerDEQueue.popBack();
        assertEquals(null, integerDEQueue.front());
    }

    @Test
    public void popFront() {
        integerDEQueue.pushBack(123);
        integerDEQueue.pushFront(456);
        integerDEQueue.popFront();
        assertEquals(Integer.valueOf(123), integerDEQueue.front());
        integerDEQueue.popFront();
        assertEquals(null, integerDEQueue.front());
        integerDEQueue.popFront();
        assertEquals(null, integerDEQueue.back());
    }

    @Test
    public void back() {
        assertEquals(null, integerDEQueue.back());
        assertEquals(null, stringDEQueue.back());
        integerDEQueue.pushFront(1);
        assertEquals(Integer.valueOf(1), integerDEQueue.back());
        integerDEQueue.pushBack(2);
        assertEquals(Integer.valueOf(2), integerDEQueue.back());
    }

    @Test
    public void front() {
        assertEquals(null, integerDEQueue.front());
        assertEquals(null, stringDEQueue.front());
        stringDEQueue.pushFront("test1");
        assertEquals("test1", stringDEQueue.front());
        stringDEQueue.pushBack("test2");
        assertEquals("test1", stringDEQueue.front());
    }

    @Test
    public void size() {
        assertEquals(0, integerDEQueue.size());
        integerDEQueue.pushBack(1);
        assertEquals(1, integerDEQueue.size());
        integerDEQueue.popFront();
        assertEquals(0, integerDEQueue.size());
        integerDEQueue.popFront();
        assertEquals(0, integerDEQueue.size());
    }

    @Test
    public void clear() throws Exception {
        integerDEQueue.pushBack(1);
        integerDEQueue.pushFront(2);
        integerDEQueue.clear();
        assertEquals(0, integerDEQueue.size());
        assertEquals(null, integerDEQueue.front());
        assertEquals(null, integerDEQueue.back());
    }

    @Test
    public void toArray() throws Exception {
        integerDEQueue.pushFront(1);
        integerDEQueue.pushFront(2);
        integerDEQueue.pushFront(3);
        assertArrayEquals(new Integer[]{1, 2, 3}, integerDEQueue.toArray() );
        stringDEQueue.pushBack("3");
        stringDEQueue.pushBack("2");
        stringDEQueue.pushBack("1");
        assertArrayEquals(new String[]{"1", "2", "3"}, stringDEQueue.toArray());
    }

}
