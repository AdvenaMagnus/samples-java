package datatypes.linkedlists;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Alexander on 31.05.2017.
 */
public class LinkedListCustom<T> {

    LinkedListNode<T> top;
    public int length=0;

    public LinkedListNode<T> getTop() {
        return top;
    }
    public void setTop(LinkedListNode<T> top) {
        this.top = top;
    }

    public void addOnTop(T value){
        LinkedListNode<T> newNode = new LinkedListNode();
        newNode.setValue(value);
        newNode.setNext(top);
        this.top = newNode;
        length++;
    }

    public void add(T value){
        LinkedListNode<T> newNode = new LinkedListNode();
        newNode.setValue(value);

        LinkedListNode<T> lastNode = getLastNode();
        if(lastNode!=null) lastNode.setNext(newNode);
        else top = newNode;
        length++;
    }

    public T getLast(){
        return getLastNode().getValue();
    }

    protected LinkedListNode<T> getLastNode(){
        LinkedListNode lastNode = top;
        if(top!=null) {
            while (lastNode.getNext() != null) {
                lastNode = lastNode.getNext();
            }
        }
        return lastNode;
    }

    public T removeFromTop(){
        if(top!=null) {
            LinkedListNode<T> removed = top;
            top = top.getNext();
            return removed.getValue();
        } else return null;
    }

    public T[] asArray(){
        T[] result =  (T[])new Object[length];
        //ArrayList<T> listResult = new ArrayList<T>();
        LinkedListNode<T> lastNode = top;
        int i=0;
        if(top!=null) {
            result[i] = top.getValue();
            //listResult.add(top.getValue());
            while (lastNode.getNext() != null) {
                result[i++] = lastNode.getValue();
                //listResult.add(lastNode.getValue());
                lastNode = lastNode.getNext();
            }
            result[i] = lastNode.getValue();
        }
        return result;
    }

    public void add(LinkedListCustom<T> toAdd){
        getLastNode().setNext(toAdd.getTop());
        length = length+toAdd.length;
    }

    /** 2.1
     Write code to remove duplicates from an unsorted linked list.
     */
    public void removeDuplicates(){
        LinkedListNode<T> currentNode = top;
        LinkedListNode<T> preCurrentNode = null;
        HashMap<T, Integer> valEntries = new HashMap<T, Integer>();
        if(top!=null) {
            while (currentNode != null) {
                if(valEntries.get(currentNode.getValue())!=null){
                    valEntries.put(currentNode.getValue(), valEntries.get(currentNode.getValue())+1);
                } else valEntries.put(currentNode.getValue(), 1);

                if(valEntries.get(currentNode.getValue())>1){
                    preCurrentNode.setNext(currentNode.getNext());
                    length--;
                }

                preCurrentNode = currentNode;
                currentNode = currentNode.getNext();
            }
        }
    }


}
