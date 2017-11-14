package rk.algos.dsaj.three;

public class BubbleSort {

    public int[] bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            boolean swapped = false;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swapped = swap(array, j);
                }
            }
            if (!swapped) {
                break;
            }
        }
        return array;
    }

    private boolean swap(int[] array, int index) {
        int temp = array[index];
        array[index] = array[index + 1];
        array[index + 1] = temp;
        return true;
    }
}
