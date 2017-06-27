package rk.algos.datastructure.stack;

/**
 * Interface defining a rk.algos.datastructure.stack
 */
public interface Stack<T> {

    /**
     * Push an item onto the stack
     * @param t Generic type T
     */
    void push(T t);

    /**
     * Pop an item from the stack
     * @return T Generic type
     */
    T pop();

    /**
     * Returns true if there are no T items in the stack
     * @return Boolean
     */
    boolean isEmpty();

    /**
     * Returns the number of T items currently in the stack
     * @return Int
     */
    int size();
}
