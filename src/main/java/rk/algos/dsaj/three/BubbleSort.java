package rk.algos.dsaj.three;

public class BubbleSort {

    private int[] array;

    public int[] bubbleSort(int[] input) {
        array = input;
        for (int i = array.length - 1; i > 0; i--) {
            boolean swapped = false;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swapped = swap(j, j + 1);
                }
            }
            if (!swapped) {
                break;
            }
        }
        return input;
    }

    private boolean swap(int lo, int high) {
        int temp = array[high];
        array[high] = array[lo];
        array[lo] = temp;
        return true;
    }
}
