package datatypes.arraystrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by Alexander on 31.05.2017.
 */
public class ArrayUtils {

    /** CtCI 1.1
     Implement an algorithm to determine if a string has all unique characters. What if you
     cannot use additional data structures?
     */
    public static boolean isAllUniqe(String str){
        HashMap<Character, Boolean> checker = new HashMap<Character, Boolean>();
        for(char c : str.toCharArray()){
            if(checker.get(c)!=null){
                return false;
            }
            checker.put(c, true);
        }
        return true;
    }

    /** CtCI 1.2
     Given two strings, write a method to decide if one is a permutation of the other.
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

    /** CtCI 1.5
        There are three types of edits that can be performed on strings: insert a character,
     remove a character, or replace a character. Given two strings, write a function to check if they are
     one edit (or zero edits) away.
     */
    public static boolean isOneStepFromEdit(String str1, String str2){
        if(str1.length()-str2.length()>1 || str2.length()-str1.length()>1) return false;
        //if (str1.equals(str2)) return true;

        if(str1.length()==str2.length()){
            boolean inconsistency = false;
            for(int i = 0; i< str1.length(); i++){
                if(str1.charAt(i)!=str2.charAt(i)){
                    if(inconsistency) return false;
                    inconsistency = true;
                }
            }
        } else {
            String strWithHighestLength;
            String strWithLowestLength;
            if (str1.length() > str2.length()) {
                strWithHighestLength = str1;
                strWithLowestLength = str2+" ";
            } else {
                strWithHighestLength = str2;
                strWithLowestLength = str1+" ";
            }
            boolean inconsistency = false;
            int i = 0, j = 0;
            for (i = 0; i < strWithHighestLength.length(); i++, j++) {
                if (strWithHighestLength.charAt(i) != strWithLowestLength.charAt(j)) {
                    if (inconsistency) return false;
                    inconsistency = true;
                    i++;
                }
            }
        }
        return true;
    }

    /** CtCI 1.6
     * Implement a method to perform basic string compression using the counts
     of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
     "compressed" string would not become smaller than the original string, your method should return
     the original string. You can assume the string has only uppercase and lowercase letters (a - z).
     * */
    public static String compressSame(String str){
        HashMap<Character, Integer> charCounter = new HashMap<Character, Integer>();
        char prev=str.charAt(0);
        StringBuilder result = new StringBuilder();

        for(char c: str.toCharArray()){
            if(charCounter.get(c)==null){
                charCounter.put(c, 1);
            } else {
                charCounter.put(c, charCounter.get(c)+1);
            }

            if(prev!=c){
                result.append(getStringToAppend(charCounter, prev));
                charCounter.put(prev, 0);
            }
            prev=c;
        }

        result.append(getStringToAppend(charCounter, prev));
        return result.toString();
    }

    public static String getStringToAppend(HashMap<Character, Integer> charCounter, char c){
        int count = charCounter.get(c);
        if(count>1){
            return ""+c+count;
        }
        return ""+c;
    }

}
