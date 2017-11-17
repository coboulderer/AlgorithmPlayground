package rk.algos.dsaj.three;

public class InsertionSort extends BaseSort {

    @Override
    public int[] sort(int[] array) {
        for (int current = 0; current < array.length; current++) {
            for (int scan = current; scan > 0; scan--) {
                if (array[scan] < array[scan - 1]) {
                    swap(array, scan, scan - 1);
                } else {
                    break;
                }
            }
        }
        return array;
    }
}
