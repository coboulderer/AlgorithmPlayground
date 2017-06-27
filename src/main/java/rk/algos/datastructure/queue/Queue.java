package rk.algos.datastructure.queue;

/**
 * Generic rk.algos.datastructure.queue.Queue Interface
 */
public interface Queue<T> {

    void enqueue(T t);

    T dequeue();

    boolean isEmpty();

    int size();
}
