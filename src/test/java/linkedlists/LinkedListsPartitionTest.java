package linkedlists;

import datatypes.linkedlists.LinkedListCustom;
import datatypes.linkedlists.utils.LinkedListUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Alexander on 07.06.2017.
 */
public class LinkedListsPartitionTest {

	LinkedListCustom<Integer> list1;
	ArrayList<Integer> right;
	ArrayList<Integer> left;

	@Before
	public void init(){
		list1 = new LinkedListCustom();
		list1.add(3);
		list1.add(5);
		list1.add(8);
		list1.add(5);
		list1.add(10);
		list1.add(2);
		list1.add(1);

		left = new ArrayList<Integer>();
		left.add(3);
		left.add(1);
		left.add(2);
		right = new ArrayList<Integer>();
		right.add(10);
		right.add(5);
		right.add(8);

	}

	@Test
	public void partitionTest(){
		LinkedListCustom<Integer> partitioned = LinkedListUtils.partition(list1, 5);

		Object[] values = partitioned.asArray();
		assertTrue(left.contains(values[0]));
		assertTrue(left.contains(values[1]));
		assertTrue(left.contains(values[2]));

		assertTrue(right.contains(values[3]));
		assertTrue(right.contains(values[4]));
		assertTrue(right.contains(values[5]));
		assertTrue(right.contains(values[6]));

		assertTrue(partitioned.length == 7);
	}


}
