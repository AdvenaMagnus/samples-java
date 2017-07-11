package datatypes.linkedlists.utils;

import datatypes.linkedlists.LinkedListCustom;
import datatypes.linkedlists.LinkedListNode;

/**
 * Created by Alexander on 11.07.2017.
 */
public class ReverseSingleLinkedList {

    public static LinkedListCustom reverse(LinkedListCustom list){
        if(list.length>1) {
            LinkedListNode current = list.getTop().getNext();
            LinkedListNode previous = list.getTop();
            LinkedListNode next = null;
            while (current != null) {
                next = current.getNext();
                current.setNext(previous);
                previous = current;
                current = next;
            }
            LinkedListCustom result = new LinkedListCustom();
            result.setTop(previous);
            result.length = list.length;
            return result;
        } else {
            return list;
        }
    }


}
