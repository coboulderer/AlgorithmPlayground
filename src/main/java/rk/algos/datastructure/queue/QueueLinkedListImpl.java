package rk.algos.datastructure.queue;

import java.util.NoSuchElementException;

import rk.algos.datastructure.LinkedListNode;

/**
 * Implementation of Queue using Linked List Data Structure
 */
public class QueueLinkedListImpl<T> implements Queue<T> {

    private LinkedListNode<T> front;
    private LinkedListNode<T> end;
    private int size;

    @Override
    public void enqueue(T t) {
        LinkedListNode oldLast = end;
        end = new LinkedListNode<>();
        end.t = t;
        end.next = null;
        if (isEmpty()) {
            front = end;
        } else {
            oldLast.next = end;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (front != null) {
            T t = front.t;
            front = front.next;
            size--;
            if (size == 0) {
                end = front;
            }
            return t;
        } else {
            throw new NoSuchElementException("Queue underflow - no items to dequeue");
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
