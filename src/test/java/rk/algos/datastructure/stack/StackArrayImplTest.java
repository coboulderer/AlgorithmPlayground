package rk.algos.datastructure.stack;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import rk.AlgoTestingBase;

/**
 * Test Class for StackArrayImpl
 */
public class StackArrayImplTest extends AlgoTestingBase {

    private Stack<Integer> stack;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setup() {
        stack = new StackArrayImpl<>();
    }

    @Test
    public void testPushSingleItem() {
        print("Beginning testPushSingleItem");
        Assert.assertTrue(stack.isEmpty());

        stack.push(1);

        Assert.assertFalse(stack.isEmpty());
        Assert.assertTrue(stack.size() == 1);

        print("Completed testPushSingleItem");
    }

    @Test
    public void testPopSingleItem() {
        print("Beginning testPopSingleItem");
        Assert.assertTrue(stack.isEmpty());

        stack.push(1);
        int value = stack.pop();

        Assert.assertTrue(value == 1);
        Assert.assertTrue(stack.isEmpty());
        Assert.assertTrue(stack.size() == 0);

        print("Completed testPushSingleItem");
    }

    @Test
    public void testPopEmptyStack() {
        print("Beginning testPopEmptyStack");

        Assert.assertTrue(stack.size() == 0);
        exception.expect(NoSuchElementException.class);
        exception.expectMessage("rk.algos.datastructure.stack.Stack underflow - nothing to pop!!");

        stack.pop();
    }

    @Test
    public void testPushThenPop() {
        print("Beginning testPushAndPop");

        for (int i = 1; i <= 10; i++) {
            stack.push(i);
            Assert.assertTrue(stack.size() == i);
        }

        for (int j = 10; j > 0; j--) {
            Assert.assertTrue(stack.pop() == j);
            Assert.assertTrue(stack.size() == j - 1);
        }

        Assert.assertTrue(stack.isEmpty());

        print("Completed testPushAndPop");
    }

    @Test
    public void testArrayResizing() {
        print("Beginning testArrayResizing");

        for (int i = 1; i <= 10; i++) {
            stack.push(i);
        }

        Assert.assertTrue(stack.size() == 10);

        stack.push(11);
        Assert.assertTrue(stack.size() == 11);

        for (int j = 11; j > 0; j--) {
            Assert.assertTrue(stack.pop() == j);
            Assert.assertTrue(stack.size() == j - 1);
        }

        Assert.assertTrue(stack.isEmpty());

        print("Completed testArrayResizing");
    }
}
