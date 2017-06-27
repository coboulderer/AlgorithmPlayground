package rk.algos.datastructure.stack;

import java.util.NoSuchElementException;

/**
 * Array Based Impl of Stack
 */
public class StackArrayImpl<T> implements Stack<T>{

    private int topOfStack;
    private T[] array;

    @SuppressWarnings("unchecked")
    public StackArrayImpl() {
        array = (T[]) new Object[10];
    }

    @Override
    public void push(T t) {
        if (topOfStack == array.length) {
            resize(array.length * 2);
        }
        array[topOfStack++] = t;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newSize) {
        T[] temp = (T[]) new Object[newSize];
        System.arraycopy(array, 0, temp, 0, topOfStack);
        array = temp;
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            T t = array[--topOfStack];
            array[topOfStack] = null;
            if (topOfStack <= array.length / 4) {
                resize(array.length / 2);
            }
            return t;
        } else {
            throw new NoSuchElementException("rk.algos.datastructure.stack.Stack underflow - nothing to pop!!");
        }
    }

    @Override
    public boolean isEmpty() {
        return topOfStack == 0;
    }

    @Override
    public int size() {
        return topOfStack;
    }
}
