package rk.algos.sorts;

/**
 * Insertion Sort using Comparable Interface
 * Good choice when data set is small or known to be partially sorted
 * O(n^2) comparisons and swaps; O(n) when partially sorted
 */
public class InsertionSort {

    public static <T extends Comparable<T>> T[] sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j].compareTo(array[j - 1]) < 0) {
                    T t = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = t;
                } else {
                    break;
                }
            }
        }
        return array;
    }
}
