import org.junit.Test;

import static org.junit.Assert.*;

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
    }

    @Test
    public void clear() throws Exception {
    }

    @Test
    public void toArray() throws Exception {
    }

}