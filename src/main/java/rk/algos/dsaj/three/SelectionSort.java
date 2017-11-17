package rk.algos.dsaj.three;

public class SelectionSort extends BaseSort {

    public int[] sort(int[] array) {
        for (int current = 0; current < array.length; current++) {
            int currentMinIndex = current;
            for (int next = current + 1; next < array.length; next++) {
                if (array[next] < array[currentMinIndex]) {
                    currentMinIndex = next;
                }
            }
            swap(array, current, currentMinIndex);
        }
        return array;
    }
}
