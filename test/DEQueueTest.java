import org.junit.Test;
import unittests.DEQueue;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Слава on 10.05.2017.
 */
public class DEQueueTest {
    @Test
    public void pushBack() throws Exception {
        DEQueue<String> st = new DEQueue<>();
        st.pushBack("asd");
        assertEquals(1, st.size());
    }

    @Test
    public void pushFront() throws Exception {
    }

    @Test
    public void popBack() throws Exception {
    }

    @Test
    public void popFront() throws Exception {
    }

    @Test
    public void back() throws Exception {
    }

    @Test
    public void front() throws Exception {
    }

    @Test
    public void size() throws Exception {
        DEQueue<Integer> q = new DEQueue<>();
        assertEquals(0, q.size());
        q.pushBack(0);
        assertEquals(1, q.size());
    }

    @Test
    public void clear() throws Exception {
        DEQueue<String> q = new DEQueue<>();
        q.pushBack("arg");
        assertEquals(1, q.size());
        q.clear();
        assertEquals(0, q.size());
    }

    @Test
    public void toArray() throws Exception {
        DEQueue<Integer> q = new DEQueue<>();
        q.pushBack(1);
        q.pushBack(2);
        q.pushBack(3);
        assertArrayEquals(new Integer[]{3, 2, 1}, q.toArray() );
    }

}