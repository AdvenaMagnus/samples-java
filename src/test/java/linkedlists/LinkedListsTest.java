package linkedlists;

import datatypes.linkedlists.LinkedListCustom;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

/**
 * Created by Alexander on 31.05.2017.
 */
public class LinkedListsTest {

    LinkedListCustom listWithDuplicates;
    LinkedListCustom listWithDuplicates2;

    @Before
    public void initLists(){
        listWithDuplicates = new LinkedListCustom();
        listWithDuplicates.add(1);
        listWithDuplicates.add(1);

        listWithDuplicates2 = new LinkedListCustom();
        listWithDuplicates2.add(1);
        listWithDuplicates2.add(2);
        listWithDuplicates2.add(2);
        listWithDuplicates2.add(3);
    }

    @Test
    public void removeDuplicatesTests(){
        listWithDuplicates.removeDuplicates();
        assertTrue(listWithDuplicates.length==1);

        listWithDuplicates2.removeDuplicates();
        assertTrue(listWithDuplicates2.length==3);
    }

}
