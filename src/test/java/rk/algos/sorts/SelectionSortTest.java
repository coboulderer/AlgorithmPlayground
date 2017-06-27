package rk.algos.sorts;

import org.junit.Test;

import rk.AlgoTestingBase;

/**
 * Test class for SelectionSort
 */
public class SelectionSortTest extends AlgoTestingBase {

    @Test
    public void testSelectionSortIntegers() {
        Integer[] integers = {3, 7, 6, 3, 10, 67, 2, 1, 500};
        SelectionSort.sort(integers);
        for (Integer integer : integers) {
            print(integer.toString());
        }
    }
}
