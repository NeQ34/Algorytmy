import lib.TQueueArray;
import lib.TQueueArrayIterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TQueueArrayTest {
    private TQueueArray<Integer> queue;

    @BeforeEach
    void TQueueArrayTest() {
        queue = new TQueueArray<>(10);
    }

    @Test
    void testPutAndIsEmpty() {
        assertTrue(queue.isEmpty());
        assertTrue(queue.put(1));
        assertFalse(queue.isEmpty());
    }

    @Test
    void testPutAndIsFull() {
        for (int i = 0; i < 10; i++) {
            Assertions.assertTrue(queue.put(i));
        }
        Assertions.assertTrue(queue.isFull());
        Assertions.assertFalse(queue.put(11));
    }

    @Test
    void testTop() {
        Assertions.assertNull(queue.top());
        queue.put(1);
        Assertions.assertEquals(1, queue.top());
        queue.put(2);
        Assertions.assertEquals(2, queue.top());
    }

    @Test
    void testGet() {
        queue.put(1);
        queue.put(2);
        Assertions.assertEquals(2, queue.get());
        Assertions.assertEquals(1, queue.size());
        Assertions.assertEquals(2, queue.get());
        Assertions.assertEquals(0, queue.size());
        Assertions.assertNull(queue.get());
    }

    @Test
    void testPop() {
        Assertions.assertFalse(queue.pop());
        queue.put(1);
        Assertions.assertTrue(queue.pop());
        Assertions.assertTrue(queue.isEmpty());
        queue.put(1);
        queue.put(2);
        Assertions.assertTrue(queue.pop());
        Assertions.assertEquals(1, queue.size());
        Assertions.assertEquals(2, queue.top());
    }

    @Test
    void testSize() {
        assertEquals(0, queue.size());
        queue.put(1);
        assertEquals(1, queue.size());
        queue.put(2);
        assertEquals(2, queue.size());
        queue.get();
        assertEquals(1, queue.size());
    }

    @Test
    void testReset() {
        queue.put(1);
        queue.put(2);
        int newHead = queue.reset(3);
        assertEquals(3, (int) queue.top());
        assertTrue(newHead >= 0 && newHead < 10);
    }

    @Test
    void testPutFront() {
        assertTrue(queue.putFront(1));
        assertEquals(1, queue.top());
        assertTrue(queue.putFront(2));
        assertEquals(2, queue.top());
    }

    @Test
    void testGetBack() {
        queue.put(1);
        queue.put(2);
        assertEquals(2, (int) queue.getBack());
        assertEquals(1, (int) queue.getBack());
        assertNull(queue.getBack());
    }

    @Test
    void testIterator() {
        queue.put(1);
        queue.put(2);
        TQueueArrayIterator<Integer> it = (TQueueArrayIterator<Integer>) queue.iterator();
        Assertions.assertTrue(it.hasNext());
        Assertions.assertEquals(1, (int) it.next());
        Assertions.assertTrue(it.hasNext());
        Assertions.assertEquals(2, (int) it.next());
        Assertions.assertFalse(it.hasNext());
    }

    @Test
    void testToString() {
        queue.put(1);
        queue.put(2);
        String expectedString = "tab[0]= 1\n" +
                "tab[1]= 2\n";
        Assertions.assertEquals(expectedString, queue.toString());
    }
}
