package rk.algos.dsaj.two;

public class OrderedArray {

    private long[] array;
    private int numElements;

    public OrderedArray(int maxElements) {
        array = new long[maxElements];
        numElements = 0;
    }

    public int size() {
        return numElements;
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = numElements - 1;
        int current;

        while (true) {
            current = (lowerBound + upperBound) / 2;
            if (array[current] == searchKey) {
                return current;
            } else if (lowerBound > upperBound) {
                return numElements;
            } else {
                if (array[current] < searchKey) {
                    lowerBound = current + 1;
                } else {
                    upperBound = current - 1;
                }
            }
        }
    }

    public void insert(long value) {
        int i;
        for (i = 0; i < numElements; i++) {
            if (array[i] > value) {
                break;
            }
        }
        for (int k = numElements; k > i; k--) {
            array[k] = array[k - 1];
        }
        array[i] = value;
        numElements++;
    }

    public boolean delete(long value) {
        int j = find(value);
        if (j == numElements) {
            return false;
        } else {
            for (int k = j; j < numElements; k++) {
                array[k] = array[k + 1];
            }
            numElements--;
            return true;
        }
    }

    public void display() {
        for (int i = 0; i < numElements; i++) {
            System.out.println(array[i]);
        }
    }

    public void merge(long[] arrayOne, long[] arrayTwo) {
        int lengthOne = arrayOne.length;
        int lengthTwo = arrayTwo.length;
        array = new long[lengthOne + lengthTwo];
        int indexOne = 0, indexTwo = 0;
        for (int i = 0; i < array.length; i++) {
            if (indexOne < arrayOne.length && indexTwo < arrayTwo.length) {
                if (arrayOne[indexOne] < arrayTwo[indexTwo]) {
                    array[i] = arrayOne[indexOne];
                    indexOne++;
                } else {
                    array[i] = arrayTwo[indexTwo];
                    indexTwo++;
                }
            } else if (indexOne >= arrayOne.length && indexTwo < arrayTwo.length) {
                array[i] = arrayTwo[indexTwo];
                indexTwo++;
            } else if (indexOne < arrayOne.length && indexTwo >= arrayTwo.length) {
                array[i] = arrayOne[indexOne];
                indexOne++;
            }
        }
    }
}
