package datatypes.arraystrings;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Alexander on 31.05.2017.
 */
public class ArrayUtils {

    /** CtCI 1.1
     Implement an algorithm to determine if a string has all unique characters. What if you
     cannot use additional data structures?
     */
    public static boolean isAllUniqe(String str){
        for(int i=0; i<str.length(); i++){
            for(int j=i+1;  j<str.length(); j++){
                if(str.charAt(i)==str.charAt(j)) return false;
            }
        }
        return true;
    }

    /** CtCI 1.2
     Given two strings, write a method to decide if one is a permutation of the
     other.
     */
    public static boolean isPermutation(String str1, String str2){
        char[] str1Sorted = str1.toCharArray();
        Arrays.sort(str1Sorted);
        char[] str2Sorted = str2.toCharArray();
        Arrays.sort(str2Sorted);
        if (new String(str1Sorted).equals(new String(str2Sorted))) return true;
        else return false;
    }

    /** CtCI 1.3
     Write a method to replace all spaces in a string with '%20'. You may assume that the string
     has sufficient space at the end to hold the additional characters, and that you are given the "true"
     length of the string. (Note: If implementing in Java, please use a character array so that you can
     perform this operation in place.)
     */
    public static  String substituteSpaces(String str, String replaceWith){
        String[] strSplitted = str.split(" +");
        StringBuilder result = new StringBuilder();
        String filler = "";
        for(String strPart : strSplitted){
            result.append(filler);
            result.append(strPart);
            filler = replaceWith;
        }
        return result.toString();
    }

    /** CtCI 1.4
     Given a string, write a function to check if it is a permutation of a palindrome.
     A palindrome is a word or phrase that is the same forwards and backwards. A permutation
     is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
     */
    public static boolean isPolindromePermutation(String str){
        HashMap<Character, Integer> entriesCount = new HashMap<Character, Integer>();
        for(char c : str.toLowerCase().toCharArray()){
            if(c!=' ') {
                if (entriesCount.get(c) != null) {
                    entriesCount.put(c, entriesCount.get(c) + 1);
                } else entriesCount.put(c, 1);
            }
        }

        boolean singleChar = false;
        for(int count : entriesCount.values()){
            if(count==1){
                if(singleChar)return false;
                singleChar = true;
            }
            if(count>2)return false;
        }
        return true;
    }


}
