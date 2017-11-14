package rk.algos.dsaj.three;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import rk.AlgoTestingBase;

public class BubbleSortTest extends AlgoTestingBase {

    @Test
    public void testBubbleSort() {
        int[] array = {3, 6, 2, 1, 0, 18, 5, 4};
        int[] ordered = {0, 1, 2, 3, 4, 5, 6, 18};
        BubbleSort bubbleSort = new BubbleSort();
        array = bubbleSort.bubbleSort(array);

        Assert.assertTrue(Arrays.equals(array, ordered));
    }
}
