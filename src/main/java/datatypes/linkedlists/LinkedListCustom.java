package datatypes.linkedlists;

import java.util.HashMap;

/**
 * Created by Alexander on 31.05.2017.
 */
public class LinkedListCustom {

    LinkedListNode top;
    public int length=0;

    public LinkedListNode getTop() {
        return top;
    }
    public void setTop(LinkedListNode top) {
        this.top = top;
    }

    public void addOnTop(int value){
        LinkedListNode newNode = new LinkedListNode();
        newNode.setIntVlaue(value);
        newNode.setNext(top);
        this.top = newNode;
        length++;
    }

    public void add(int value){
        LinkedListNode newNode = new LinkedListNode();
        newNode.setIntVlaue(value);

        LinkedListNode lastNode = getLastNode();
        if(lastNode!=null) lastNode.setNext(newNode);
        else top = newNode;
        length++;
    }

    protected LinkedListNode getLastNode(){
        LinkedListNode lastNode = top;
        if(top!=null) {
            while (lastNode.getNext() != null) {
                lastNode = lastNode.getNext();
            }
        }
        return lastNode;
    }

    /** 2.1
     Write code to remove duplicates from an unsorted linked list.
     */
    public void removeDuplicates(){
        LinkedListNode currentNode = top;
        LinkedListNode preCurrentNode = null;
        HashMap<Integer, Integer> valEntries = new HashMap<Integer, Integer>();
        if(top!=null) {
            while (currentNode != null) {
                if(valEntries.get(currentNode.getIntVlaue())!=null){
                    valEntries.put(currentNode.getIntVlaue(), valEntries.get(currentNode.getIntVlaue())+1);
                } else valEntries.put(currentNode.getIntVlaue(), 1);

                if(valEntries.get(currentNode.getIntVlaue())>1){
                    preCurrentNode.setNext(currentNode.getNext());
                    length--;
                }

                preCurrentNode = currentNode;
                currentNode = currentNode.getNext();
            }
        }
    }


}
