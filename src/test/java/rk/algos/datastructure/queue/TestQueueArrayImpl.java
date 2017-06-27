package rk.algos.datastructure.queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import rk.AlgoTestingBase;

/**
 * Test class for QueueArrayImpl
 */
public class TestQueueArrayImpl extends AlgoTestingBase {

    Queue<Integer> queue;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setup() {
        queue = new QueueArrayImpl<>();
    }

    @Test
    public void testIsEmpty() {
        print("Beginning testIsEmpty");
        Assert.assertTrue(queue.isEmpty());
        Assert.assertTrue(queue.size() == 0);
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        Assert.assertTrue(queue.isEmpty());
        Assert.assertTrue(queue.size() == 0);
        print("Completed testIsEmpty");
    }

    @Test
    public void testEnqueueToCapacity() {
        print("Beginning testEnqueueToCapacity");
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        Assert.assertFalse(queue.isEmpty());
        Assert.assertTrue(queue.size() == 10);
        print("Completed testEnqueueToCapacity");
    }

    @Test
    public void testQueueOverflow() {
        print("Beginning testQueueOverflow");
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }

        exception.expect(IndexOutOfBoundsException.class);
        exception.expectMessage("Queue Overflow!!!");

        queue.enqueue(11);
    }

    @Test
    public void testSimpleDequeue() {
        //TODO
    }

    @Test
    public void testDequeueUnderflow() {
        //TODO
    }

    @Test
    public void testEnqueueAndDequeueWrapping() {
        //TODO
    }
}
