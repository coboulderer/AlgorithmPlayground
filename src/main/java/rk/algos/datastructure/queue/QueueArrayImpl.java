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
        array = (T[]) new Object[10];
    }

    @SuppressWarnings("unchecked")
    public QueueArrayImpl(int initialSize) {
        array = (T[]) new Object[initialSize];
    }

    @Override
    public void enqueue(T t) {
        if (size >= array.length) {
            throw new IndexOutOfBoundsException("Queue Overflow!!!");
        } else {
            if (rear == array.length) {
                rear = 0;
            }
            array[rear++] = t;
            size++;
        }
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
