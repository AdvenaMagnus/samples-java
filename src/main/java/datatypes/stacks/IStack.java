package datatypes.stacks;

/**
 * Created by Alexander on 02.06.2017.
 */
public interface IStack<T> {

    T pop();
    T peek();
    void push(T item);
    boolean isEmpty();


}
