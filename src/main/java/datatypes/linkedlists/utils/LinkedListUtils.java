package datatypes.linkedlists.utils;

import datatypes.linkedlists.LinkedListCustom;

/**
 * Created by Alexander on 31.05.2017.
 */
public class LinkedListUtils {

	/** CtCI 2.4
	 * Write code to partition a linked list around a value x, such that all nodes less than x come
	 before all nodes greater than or equal to x. If x is contained within the list, the values of x only need
	 to be after the elements less than x (see below). The partition element x can appear anywhere in the
	 "right partition"; it does not need to appear between the left and right partitions.
	 * */
	public static LinkedListCustom<Integer> partition(LinkedListCustom<Integer> list, int partition){

		LinkedListCustom<Integer> left = new LinkedListCustom();
		LinkedListCustom<Integer> right = new LinkedListCustom();

		Integer val = null;
		while((val = list.removeFromTop())!=null){
			if(val<partition) left.add(val);
			else right.add(val);
		}
		left.add(right);
		return left;
	}

}
