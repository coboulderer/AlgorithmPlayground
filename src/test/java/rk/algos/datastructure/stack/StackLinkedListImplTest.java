package rk.algos.datastructure.stack;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import rk.AlgoTestingBase;

/**
 * Test class for StackLinkedListImpl
 */
public class StackLinkedListImplTest extends AlgoTestingBase {

    private Stack<Integer> stack;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setup() {
        stack = new StackLinkedListImpl<>();
    }

    @Test
    public void testPushSingleItem() {
        print("Beginning testPush");

        Assert.assertTrue(stack.isEmpty());
        Assert.assertTrue(stack.size() == 0);

        stack.push(1);

        Assert.assertTrue(stack.size() == 1);
        Assert.assertFalse(stack.isEmpty());

        print("Completed testPush");
    }

    @Test
    public void testPopSingleItem() {
        print("Beginning testPop");

        Assert.assertTrue(stack.isEmpty());
        Assert.assertTrue(stack.size() == 0);

        stack.push(1);
        int num = stack.pop();

        Assert.assertTrue(num == 1);
        Assert.assertTrue(stack.size() == 0);
        Assert.assertTrue(stack.isEmpty());

        print("Completed testPop");
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
}
