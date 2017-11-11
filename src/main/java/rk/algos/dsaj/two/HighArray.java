package rk.algos.dsaj.two;

public class HighArray {

    private long[] array;
    private int numElements;

    public HighArray(int max) {
        array = new long[max];
        numElements = 0;
    }

    public boolean find(long key) {
        boolean found = false;
        for (int i = 0; i < numElements; i++) {
            if (array[i] == key) {
                found = true;
                break;
            }
        }
        return found;
    }

    public void insert(long value) {
        array[numElements] = value;
        numElements++;
    }

    public boolean delete(long value) {
        boolean deleted = false;
        if (find(value)) {
            for (int i = 0; i < numElements; i++) {
                if (array[i] == value) {
                    removeValueAt(i);
                    numElements--;
                    deleted = true;
                    break;
                }
            }
        }
        return deleted;
    }

    private void removeValueAt(int index) {
        for (int i = index; i < array.length; i++) {
            if (i != array.length - 1) {
                array[i] = array[i + 1];
            } else {
                array[i] = 0L;
            }
        }
    }

    public void display() {
        for (int i = 0; i < numElements; i++) {
            System.out.println("Value at array[" + i + "] = " + array[i]);
        }
    }

    public long removeMax() {
        if (numElements == 0) {
            return -1;
        } else {
            long maxValue = Long.MIN_VALUE;
            int maxIndex = 0;
            for (int i = 0; i < numElements; i++) {
                if (array[i] >= maxValue) {
                    maxValue = array[i];
                    maxIndex = i;
                }
            }
            removeValueAt(maxIndex);
            return maxValue;
        }
    }
}
