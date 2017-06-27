package rk.algos.sorts;

/**
 * Selection sort implementation leveraging Java Comparable interface
 * O(n^2) compares, O(n) swaps, not stable.  Behavior does not change, regardless of
 * date
 */
public class SelectionSort {

    public static <T extends Comparable<T>> T[] sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min].compareTo(array[j]) > 0) {
                    min = j;
                }
            }
            T t = array[min];
            array[min] = array[i];
            array[i] = t;
        }
        return array;
    }
}
