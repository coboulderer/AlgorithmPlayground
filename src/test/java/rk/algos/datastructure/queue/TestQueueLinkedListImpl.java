package rk.algos.datastructure.queue;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import rk.AlgoTestingBase;

/**
 * Test class for QueueLinkedListImpl
 */
public class TestQueueLinkedListImpl extends AlgoTestingBase {

    private Queue<Integer> queue;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setup() {
        queue = new QueueLinkedListImpl<>();
    }

    @Test
    public void testIsEmpty() {
        print("Beginning testIsEmpty");
        Assert.assertTrue(queue.isEmpty());
        print("Completed testIsEmpty");
    }

    @Test
    public void testIsNotEmpty() {
        print("Beginning testIsNotEmpty");
        queue.enqueue(1);
        Assert.assertFalse(queue.isEmpty());
        print("Completed testIsNotEmpty");
    }

    @Test
    public void testEnqueue() {
        print("Beginning testEnqueue");
        Assert.assertTrue(queue.size() == 0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        Assert.assertFalse(queue.isEmpty());
        Assert.assertTrue(queue.size() == 4);

        print("Completed testEnqueue");
    }

    @Test
    public void testDequeue() {
        print("Beginning testDequeue");
        Assert.assertTrue(queue.isEmpty());
        for (int i = 0; i <= 5 ; i++) {
            queue.enqueue(i);
        }
        Assert.assertTrue("Queue size is = " + queue.size(), queue.size() == 6);
        Assert.assertFalse(queue.isEmpty());
        for (int j = 0; j <= 5; j++) {
            int value = queue.dequeue();
            print("Current value " + value);
            Assert.assertTrue(value == j);
        }
        Assert.assertTrue(queue.isEmpty());

        print("Completed testEnqueue");
    }

    @Test
    public void testDequeueEmptyQueue() {
        print("Beginning testDequeueEmptyQueue");
        Assert.assertTrue(queue.isEmpty());

        exception.expect(NoSuchElementException.class);
        exception.expectMessage("Queue underflow - no items to dequeue");
        queue.dequeue();

        print("Completed testDequeueEmptyQueue");
    }
}
