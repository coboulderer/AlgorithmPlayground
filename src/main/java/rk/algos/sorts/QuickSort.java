package rk.algos.sorts;

import java.util.Random;

/**
 * Quicksort Implementation utilizing generics
 */
public class QuickSort {

    public static <T extends Comparable<T>> void quickSort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] array, int lowIndex, int highIndex) {
        if (lowIndex < highIndex) {
            int p = choosePivot(lowIndex, highIndex);
            if (p != lowIndex) {
                swapElements(array, lowIndex, p);
            }
            p = partitionAroundP(array, lowIndex, highIndex);
            quickSort(array, lowIndex, p - 1);
            quickSort(array, p + 1, highIndex);
        }
    }

    private static <T extends Comparable<T>> void swapElements(T[] array, int firstElement, int secondElement) {
        T swappedElement = array[firstElement];
        array[firstElement] = array[secondElement];
        array[secondElement] = swappedElement;
    }

    private static int choosePivot(int lowIndex, int highIndex) {
        Random random = new Random();
        return random.nextInt(highIndex - lowIndex + 1) + lowIndex;
    }

    private static <T extends Comparable<T>> int partitionAroundP(T[] array, int lowIndex, int highIndex) {
        T pivotValue = array[lowIndex];
        int i = lowIndex + 1;
        for (int j = lowIndex + 1; j <= highIndex; j++) {
            if (array[j].compareTo(pivotValue) < 0) {
                swapElements(array, j, i);
                i++;
            }
        }
        swapElements(array, lowIndex, i - 1);
        return i - 1;
    }
}
