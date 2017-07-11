package basics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Alexander on 01.07.2017.
 */
public class Basics {

    @Test
    public void primitives(){
        long l1 = 10;
        double d1 = 20;
        //int i1 = l1; error
        int i1 = 30;
        long l2 = i1;
        //byte b = 255; error; диапазон значений для byte: от -128 до 127
        // All primitives in java - signed

        int i2 = new Integer(10);
        char b1 = 10;
        //char b2 = -1; error

        //if(i2=12)... error
        boolean bu1 = false;
        if(bu1=true) assertTrue(true); // condition doesn't match

        char c2 = '\u0031';
    }

    @Test
    public void switchCase(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 4 ; ) {
            switch(new Integer(i++)) {
                case 1:
                    sb.append("one ");
                    break;
                case 3:
                    sb.append("three ");
                case 4:
                    sb.append("four ");
                default:
                    sb.append("def ");
            }
        }
        assertEquals("def one def three four def ", sb.toString());
    }

    public static void main1(String arg[]){}
    public static void main2(String[] arg){}


    @Test
    public void finallyTest(){
        assertTrue(summ(5,5)==0);
    }

    public int summ(int a, int b) {
        try {
            return a + b;
        } finally {
            if (a == b)
                return 0;
        }
    }

    @Test
    public void strings(){
        String s1 = "example";
        String s2 = new String("example");

        assertTrue(s1!=s2);
        s2 = s2.intern();
        assertTrue(s1==s2);
    }

}
