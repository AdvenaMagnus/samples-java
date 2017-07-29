package datatypes.strings;

import java.util.ArrayList;

/**
 * Created by Alexander on 28.07.2017.
 */
public class OperationsOnBigDigits {

    public static String sum(String dString1, String dString2){
        int i = dString1.length()-1;
        int j = dString2.length()-1;

        Stack result = new OperationsOnBigDigits().new Stack();
        boolean residue = false;
        for(;i>=0 || j>=0; i--, j--){
            int d1 = i>-1? java.lang.Integer.parseInt(""+dString1.charAt(i)):0;
            int d2 = j>-1? java.lang.Integer.parseInt(""+dString2.charAt(j)):0;

            int sum = d1 + d2;
            if(residue) sum++;
            if(sum>9){
                result.push((""+(sum-10)).charAt(0));
                residue = true;
            } else {
                result.push((""+sum).charAt(0));
                residue = false;
            }
        }
        if(residue) result.push('1');

        return popStack(result);
    }


    static String popStack(Stack stack){
        StringBuilder sbResult = new StringBuilder();
        while (stack.top!=null){
            sbResult.append(stack.pop());
        }
        return sbResult.toString();
    }

    class StackNode{
        Character data;
        StackNode next;
    }

    class Stack{
        StackNode top;
        int size=0;
        Character pop(){
            if(top!=null){
                Character result = top.data;
                top = top.next;
                size--;
                return result;
            }
            else return null;
        }

        void push(Character c){
            StackNode newNode= new StackNode();
            newNode.data = c;
            newNode.next = top;
            size++;
            top = newNode;
        }
    }

    public static String multiply(String dString1, String dString2){
        int dString1Length = dString2.length()-1;
        ArrayList<Stack> toSum = new ArrayList<Stack>();
        for(int i = dString1Length; i>=0; i--){
            Stack mult = multiplyOnStack(dString1, dString2.charAt(i));
            toSum.add(mult);
        }
        return popStack(specialSum(toSum)).replaceFirst("^0+(?!$)", "");
    }

    public static Stack multiplyOnStack(String dString1, char d2){
        Stack result = new OperationsOnBigDigits().new Stack();
        int length = dString1.length()-1;
        int d2Parsed = java.lang.Integer.parseInt(""+d2);
        int residue = 0;
        for(int i = length; i>=0; i--){
            int parsed = java.lang.Integer.parseInt(""+dString1.charAt(i));
            int muliplication = parsed*d2Parsed+residue;
            if(muliplication>9){
                int lastD = muliplication%10;
                residue = (muliplication-lastD)/10;
                result.push((""+ lastD).charAt(0));
            } else {
                result.push((""+ muliplication).charAt(0));
                residue = 0;
            }
        }
        result.push((""+ residue).charAt(0));
        return result;
    }

    public static String multiply(String dString1, char d2){
        return popStack(multiplyOnStack(dString1, d2));
    }

    public static Stack specialSum(ArrayList<Stack> arg){
        Stack result = new OperationsOnBigDigits().new Stack();
        flipStack(arg.get(0));

        for(int i=1; i<arg.size(); i++){
            flipStack(arg.get(i));
            for(int j=0; j<i; j++){
                arg.get(i).push('0');
            }
        }

        int size = 1;
        int residue = 0;
        while (size>0){
            int sum = 0;
            size = 0;
            for(int i=0; i<arg.size(); i++){
                if(arg.get(i).top!=null){
                    sum = sum + java.lang.Integer.parseInt(""+arg.get(i).pop());
                }
                if(arg.get(i).size>size) size = arg.get(i).size;
            }
            sum = sum + residue;
            if(sum>9){
                DigitDecomposed digitDecomposed = decomposeDigit(sum);
                result.push(digitDecomposed.last);
                residue = java.lang.Integer.parseInt(digitDecomposed.first);
            } else {
                result.push((""+sum).charAt(0));
                residue = 0;
            }
        }
        return result;
    }

    static void flipStack(Stack stack){
        StackNode cur = stack.top.next;
        StackNode prev = stack.top;
        while (cur!=null){
            StackNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        stack.top.next=null;
        stack.top = prev;
    }

    static DigitDecomposed decomposeDigit(int d){
        String dString = ""+d;
        DigitDecomposed digitDecomposed = new OperationsOnBigDigits().new DigitDecomposed();
        digitDecomposed.first = dString.substring(0, dString.length()-1);
        digitDecomposed.last = dString.charAt(dString.length()-1);
        return digitDecomposed;
    }

    class DigitDecomposed{
        String first;
        char last;
    }

}
