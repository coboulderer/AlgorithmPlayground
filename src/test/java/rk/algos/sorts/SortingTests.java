package rk.algos.sorts;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import rk.AlgoTestingBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Test class for SelectionSort
 */
public class SortingTests extends AlgoTestingBase {

    private Integer[] integers;

    @Before
    public void setup() {
        integers = new Integer[]{3, 2, 7, 1, 5, 6, 4, 8, 10, 9};
    }

    @Test
    public void testInsertionSortIntegers() {
        print("Testing Insertion Sort");
        InsertionSort.sort(integers);
        isSorted(integers);
    }

    @Test
    public void testSelectionSortIntegers() {
        print("Testing Selection Sort");
        SelectionSort.sort(integers);
        isSorted(integers);
    }

    @Test
    public void testMergeSort() {
        print("Testing Mergesort");
        MergeSort.sort(integers);
        isSorted(integers);
    }

    @Test
    public void checkMergeSortInversions() {
        print("Checking Inversions in Small Array");
        Integer[] integers = {1, 3, 5, 8, 2, 4, 6, 7};
        MergeSort.sort(integers);
        assertThat(MergeSort.inversionCounter, is(equalTo(7L)));
    }

    @Test
    public void checkInversionsFromFile() {
        Integer[] intsFromFile = readIntsFromFile("IntegerArray.txt", 10000);
        MergeSort.sort(intsFromFile);
        print("Inversions:: " + MergeSort.inversionCounter);
    }

    private Integer[] readIntsFromFile(String fileName, int size) {
        Integer[] intsFromFile = new Integer[size];
        try (Scanner scanner = new Scanner(new File(getClass().getClassLoader().
                getResource(fileName).getFile()))) {
            for (int i = 0; scanner.hasNextInt() && i < intsFromFile.length; i++ ) {
                intsFromFile[i] = scanner.nextInt();
            }
        } catch (NullPointerException | FileNotFoundException e) {
            print("Could not find file:: " + e.getMessage());
        }
        return intsFromFile;
    }

    @Test
    public void testQuickSort() {
        print("Testing basic quicksort");
        Integer[] quickSortInts = readIntsFromFile("QuickSortTestFile.txt", 10000);
        QuickSort.quickSort(quickSortInts);
        isSorted(quickSortInts);
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
