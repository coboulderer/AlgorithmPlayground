package rk.algos.sorts;

/**
 * Mergesort Implementation using Java Comparable Interface
 * Notes etc. - Java uses Mergesort on Objects, Quicksort for
 */
public class MergeSort {

    public static long inversionCounter = 0;

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void sort(T[] array) {
        T[] aux = (T[])new Comparable[array.length];
        inversionCounter = 0;
        sort(array, aux, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void sort(T[] array, T[] aux, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(array, aux, lo, mid);
        sort(array, aux, mid + 1, hi);
        merge(array, aux, lo, mid, hi);
    }

    private static <T extends Comparable<T>> void merge(T[] array, T[] aux, int lo, int mid, int hi) {

        for (int k = lo; k <= hi; k++) {
            aux[k] = array[k];
        }

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                array[k] = aux[j];
                j++;
            } else if (j > hi) {
                array[k] = aux[i];
                i++;
            } else if (aux[j].compareTo(aux[i]) < 0) {
                inversionCounter += (mid + 1 - i);
                array[k] = aux[j];
                j++;
            } else {
                array[k] = aux[i];
                i++;
            }
        }
    }
}
