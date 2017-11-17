package rk.algos.dsaj.three;

public class BubbleSort extends BaseSort{

    public int[] sort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            boolean swapped = false;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swapped = swap(array, j, j + 1);
                }
            }
            if (!swapped) {
                break;
            }
        }
        return array;
    }
}
