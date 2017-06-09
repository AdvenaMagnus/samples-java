package datatypes.linkedlists;

/**
 * Created by Alexander on 31.05.2017.
 */
public class LinkedListNode<T> {

    T value;
    LinkedListNode next;

    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }

    public LinkedListNode getNext() {
        return next;
    }
    public void setNext(LinkedListNode next) {
        this.next = next;
    }
}
