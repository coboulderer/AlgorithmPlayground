package rk.algos.sorts;

import org.junit.Assert;
import org.junit.Test;

import rk.AlgoTestingBase;

/**
 * Test class for SelectionSort
 */
public class SortingTests extends AlgoTestingBase {

    @Test
    public void testInsertionSortIntegers(){
        print("Testing Insertion Sort");
        Integer[] integers = {3, 2, 7, 1, 5, 6, 4, 8, 10, 9};
        InsertionSort.sort(integers);
        isSorted(integers);
    }

    @Test
    public void testSelectionSortIntegers() {
        print("Testing Selection Sort");
        Integer[] integers = {3, 2, 7, 1, 5, 6, 4, 8, 10, 9};
        SelectionSort.sort(integers);
        isSorted(integers);
    }

    @Test
    public void testMergeSort() {
        print("Testing Mergesort");
        Integer[] integers = {3, 2, 7, 1, 5, 6, 4, 8, 10, 9};
        MergeSort.sort(integers);
        isSorted(integers);
    }

    private void isSorted(Integer[] integers) {
        int i = 1;
        for (Integer integer : integers) {
            Assert.assertTrue(integer == i);
            print(integer.toString());
            i++;
        }
    }
}
