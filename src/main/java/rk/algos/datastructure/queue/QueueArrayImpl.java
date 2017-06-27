package rk.algos.datastructure.queue;

import java.util.NoSuchElementException;

/**
 * Queue Implementation using Array
 */
public class QueueArrayImpl<T> implements Queue<T> {

    private T[] array;
    private int front;
    private int rear;
    private int size;

    @SuppressWarnings("unchecked")
    public QueueArrayImpl() {
        array = (T[]) new Object[2];
    }

    @Override
    public void enqueue(T t) {
        if (size == array.length) {
            resize(2 * array.length);
        }
        array[rear++] = t;
        if (rear == array.length) {
            rear = 0;
        }
        size++;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        T[] temp = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            temp[i] = array[(front + i) % array.length];
        }
        array = temp;
        front = 0;
        rear = size;
    }

    @Override
    public T dequeue() {
        if (!isEmpty()) {
            T t = array[front];
            array[front++] = null;
            size--;
            if (front == array.length) {
                front = 0;
            }
            if (size > 0 && size == array.length / 4) {
                resize(array.length / 2);
            }
            return t;
        } else {
            throw new NoSuchElementException("Queue underflow - no items in the queue to dequeue");
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
