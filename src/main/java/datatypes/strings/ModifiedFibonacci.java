package datatypes.strings;

/**
 * Created by Alexander on 28.07.2017.
 */

import java.util.ArrayList;

public class ModifiedFibonacci {

    public static String calculate(int t1, int t2, int n){
        ArrayList<String> modifiedFibSeq = new ArrayList<String>();

        modifiedFibSeq.add(""+t1);
        modifiedFibSeq.add(""+t2);
        for(int i=2; i<n; i++){
            System.out.println("mFibonacci - "+i);
            modifiedFibSeq.add(nextVal(modifiedFibSeq.get(i-2),modifiedFibSeq.get(i-1)));
        }

        return modifiedFibSeq.get(n-1);
    }

    static String nextVal(String s1, String s2){
        System.out.println("Square");
        String s2squared = OperationsOnBigDigits.multiply(s2, s2);
        System.out.println("Sum");
        return OperationsOnBigDigits.sum(s1, s2squared);
    }

}
