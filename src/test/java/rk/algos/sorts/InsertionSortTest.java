package rk.algos.sorts;

import org.junit.Test;

import rk.AlgoTestingBase;

/**
 * Test class for InsertionSort
 */
public class InsertionSortTest extends AlgoTestingBase {

    @Test
    public void testSelectionSortIntegers(){
        Integer[] integers = {3, 7, 6, 3, 10, 67, 2, 1, 500};
        InsertionSort.sort(integers);
        for (Integer integer : integers) {
            print(integer.toString());
        }
    }
}
