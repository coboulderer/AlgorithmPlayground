package rk.algos.dsaj.three;

public abstract class BaseSort {

    public abstract int[] sort(int[] array);

    boolean swap(int[] array, int loIndex, int highIndex) {
        int temp = array[loIndex];
        array[loIndex] = array[highIndex];
        array[highIndex] = temp;
        return true;
    }
}
