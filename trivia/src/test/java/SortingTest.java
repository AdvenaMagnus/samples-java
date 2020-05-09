import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Alexander on 19.08.2017.
 */
public class SortingTest {

    @Test
    public void testCombSort(){
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(4,2,5,3,1));
        list = (ArrayList<Integer>) Sorts.combsort(list);
        for(int i=0; i<5; i++){
            assertTrue(list.get(i)==i+1);
        }
    }

    @Test
    public void testCombSort2(){
        int digitsCount = 100000;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<digitsCount; i++){
            list.add(ThreadLocalRandom.current().nextInt(0, 1000000));
        }
        list = (ArrayList<Integer>) Sorts.combsort(list);
//        for(int i=0; i<digitsCount; i++){
//            assertTrue(list.get(i)==i+1);
//        }
        int max=0;
        for(int e : list){
            if(max>e)
                assertTrue(false);
            max=e;
        }
    }

    @Test
    public void testQuickSort(){
        int digitsCount = 100000;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<digitsCount; i++){
            list.add(ThreadLocalRandom.current().nextInt(0, 1000000));
        }
        list = (ArrayList<Integer>) Sorts.quicksort(list);
//        for(int i=0; i<digitsCount; i++){
//            assertTrue(list.get(i)==i+1);
//        }
        int max=0;
        for(int e : list){
            if(max>e) assertTrue(false);
            max=e;
        }
    }
}
