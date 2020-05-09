package linkedlists;

import datatypes.linkedlists.LinkedListCustom;
import datatypes.linkedlists.LinkedListNode;
import datatypes.linkedlists.utils.ReverseSingleLinkedList;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Alexander on 11.07.2017.
 */
public class ReverseSingleLinkedListTest {

    @Test
    public void test(){
        LinkedListCustom<Integer> list = new LinkedListCustom<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        LinkedListCustom<Integer> listReversed =  ReverseSingleLinkedList.reverse(list);

        LinkedListNode iterator = listReversed.getTop();
        for(int i=4; i>0; i--){
            assertTrue((Integer)iterator.getValue()==i);
            iterator= iterator.getNext();
        }
        assertTrue(list==listReversed);
    }

    @Test
    public void test2(){
        LinkedListCustom<Integer> list = new LinkedListCustom<Integer>();
        list.add(1);
        list.add(2);

        LinkedListCustom<Integer> listReversed =  ReverseSingleLinkedList.reverse(list);

        LinkedListNode iterator = listReversed.getTop();
        for(int i=2; i>0; i--){
            assertTrue((Integer)iterator.getValue()==i);
            iterator= iterator.getNext();
        }
        assertTrue(list==listReversed);
    }


}
