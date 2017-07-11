package rk.algos.sorts;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import rk.AlgoTestingBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

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

    @Test
    public void checkMergeSortInversions() {
        print("Checking Inversions in Small Array");
        Integer[] integers = {1, 3, 5, 8, 2, 4, 6, 7};
        MergeSort.sort(integers);
        assertThat(MergeSort.inversionCounter, is(equalTo(7)));
    }

    @Test
    public void checkInversionsFromFile() {
        Integer[] intsFromFile = new Integer[100000];
        try (Scanner scanner = new Scanner(new File(getClass().getClassLoader().
                getResource("IntegerArray.txt").getFile()))) {
            for (int i = 0; scanner.hasNextInt() && i < intsFromFile.length; i++ ) {
                intsFromFile[i] = scanner.nextInt();
            }
            MergeSort.sort(intsFromFile);
            print("Inversions:: " + MergeSort.inversionCounter);
        } catch (NullPointerException | FileNotFoundException e) {
            print("Could not find file:: " + e.getMessage());
        }
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
