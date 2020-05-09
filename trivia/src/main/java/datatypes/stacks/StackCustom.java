package datatypes.stacks;

/**
 * Created by Alexander on 02.06.2017.
 */
public class StackCustom<T> implements IStack<T> {

    StackNode<T> top;

    public T pop() {
        T toReturn = null;
        if(top!=null){
            toReturn = top.data;
            top = top.next;
            return toReturn;
        }
        return toReturn;
    }

    public T peek() {
        if(top!=null) return top.data;
        return null;
    }

    public void push(T item) {
        StackNode<T> newNode = new StackNode<T>();
        newNode.data = item;
        newNode.next = top;
        if(top!=null) newNode.min = min(item, top.min);
        else newNode.min = item;
        top = newNode;
    }

    public boolean isEmpty() {
        return top==null;
    }

    public T min(){
        return top!=null? top.min: null;
    }

    public T min(T val1, T val2){
        return null;
    }
}
