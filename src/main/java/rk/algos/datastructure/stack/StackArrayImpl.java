package rk.algos.datastructure.stack;

import java.util.NoSuchElementException;

/**
 * Array Based Impl of Stack
 */
public class StackArrayImpl<T> implements Stack<T>{

    private int stackSize;
    private T[] array;

    @SuppressWarnings("unchecked")
    public StackArrayImpl() {
        array = (T[]) new Object[10];
    }

    @SuppressWarnings("unchecked")
    public StackArrayImpl(int initialStackSize) {
        this.stackSize = initialStackSize;
        array = (T[]) new Object[stackSize];
    }

    @Override
    public void push(T t) {
        checkAndDoubleArraySize();
        array[stackSize++] = t;
    }

    @SuppressWarnings("unchecked")
    private void checkAndDoubleArraySize() {
        if (stackSize == array.length) {
            T[] temp = (T[]) new Object[array.length * 2];
            System.arraycopy(array, 0, temp, 0, array.length);
            array = temp;
        }
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            T t = array[--stackSize];
            array[stackSize] = null;
            checkAndHalfArraySize();
            return t;
        } else {
            throw new NoSuchElementException("rk.algos.datastructure.stack.Stack underflow - nothing to pop!!");
        }
    }

    @SuppressWarnings("unchecked")
    private void checkAndHalfArraySize() {
        if (stackSize <= array.length / 4) {
            T[] temp = (T[]) new Object[array.length / 2];
            System.arraycopy(array, 0, temp, 0, stackSize);
            array = temp;
        }
    }

    @Override
    public boolean isEmpty() {
        return stackSize == 0;
    }

    @Override
    public int size() {
        return stackSize;
    }
}
