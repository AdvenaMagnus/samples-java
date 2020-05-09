package stacks;

import datatypes.stacks.StackCustom;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

/**
 * Created by Alexander on 02.06.2017.
 */

public class StackTests {

    StackCustom<Integer> stack1;
    StackCustom<Integer> stack2;

    @Before
    public void init(){
        stack1 = new StackCustom<Integer>();
        stack1.push(3);
        stack1.push(2);
        stack1.push(1);

        stack2 = new StackCustom<Integer>(){
            public Integer min(Integer val1, Integer val2){
                if(val1!=null && val2!=null)
                    return Math.min(val1, val2);
                if(val1==null)return val2;
                if(val2==null)return val1;
                return 0;
            }
        };
        stack2.push(4);
        stack2.push(1);
        stack2.push(3);
        stack2.push(1);
        stack2.push(2);
        stack2.push(5);
        stack2.push(2);
    }

    @Test
    public void SimpleStackTest(){

        assertTrue(stack1.peek()==1);
        assertTrue(stack1.pop()==1);

        assertTrue(stack1.peek()==2);
        assertTrue(stack1.pop()==2);

        assertTrue(stack1.peek()==3);
        assertTrue(stack1.pop()==3);

    }


    /** 3.2
     How would you design a stack which, in addition to push and pop, has a function min
     which returns the minimum element? Push, pop and min should all operate in 0(1) time.
     * */
    @Test
    public void MinTest(){
        assertTrue(stack2.min()==1);
        stack2.pop();
        assertTrue(stack2.min()==1);

        for(int i =0; i<5; i++) stack2.pop();

        assertTrue(stack2.min()==4);
    }

}
