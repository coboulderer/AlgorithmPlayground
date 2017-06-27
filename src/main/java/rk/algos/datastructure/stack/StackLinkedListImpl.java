package rk.algos.datastructure.stack;

import java.util.NoSuchElementException;

import rk.algos.datastructure.LinkedListNode;

/**
 * Stack Data Structure using a Linked List
 */
public class StackLinkedListImpl<T> implements Stack<T> {

    private LinkedListNode<T> front;
    private int size;

    @Override
    public void push(T t) {
        LinkedListNode<T> oldFront = front;
        front = new LinkedListNode<>();
        front.t = t;
        front.next = oldFront;
        size++;
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            T t = front.t;
            front = front.next;
            size--;
            return t;
        } else {
            throw new NoSuchElementException("rk.algos.datastructure.stack.Stack underflow - nothing to pop!!");
        }
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int size() {
        return size;
    }
}
