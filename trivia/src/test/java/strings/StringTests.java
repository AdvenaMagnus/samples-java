package strings;

import datatypes.arraystrings.ArrayUtils;
import org.junit.Test;

import static junit.framework.TestCase.*;

/**
 * Created by Alexander on 31.05.2017.
 */
public class StringTests {

    @Test
    public void isAllUniqueTest(){
       assertTrue(ArrayUtils.isAllUniqe("abc"));
       assertFalse(ArrayUtils.isAllUniqe("aabc"));
       assertFalse(ArrayUtils.isAllUniqe("abca"));
       assertFalse(ArrayUtils.isAllUniqe("abac"));
    }

    @Test
    public void isPermutationTest(){
        assertTrue(ArrayUtils.isPermutation("abc", "cba"));
        assertFalse(ArrayUtils.isPermutation("abcg", "cba"));
    }

    @Test
    public void substituteSpacesTest(){
        assertEquals("Mr%20John%20Smith", ArrayUtils.substituteSpaces("Mr John Smith  ", "%20"));
    }

    @Test
    public void isPalindromePermutTest(){
        assertTrue(ArrayUtils.isPolindromePermutation("Tact Coa"));
        assertFalse(ArrayUtils.isPolindromePermutation("aAabb"));
    }

    @Test
    public void isOneWayFromEditTest(){
        assertTrue(ArrayUtils.isOneStepFromEdit("pale", "ple"));
        assertTrue(ArrayUtils.isOneStepFromEdit("pales", "pale"));
        assertTrue(ArrayUtils.isOneStepFromEdit("ales", "pales"));
        assertTrue(ArrayUtils.isOneStepFromEdit("palef", "pakef"));
        assertFalse(ArrayUtils.isOneStepFromEdit("palesa", "pale"));
        assertFalse(ArrayUtils.isOneStepFromEdit("palesa", "pake"));
        assertFalse(ArrayUtils.isOneStepFromEdit("pale", "bake"));
        assertFalse(ArrayUtils.isOneStepFromEdit("pale", "paleta"));
        assertFalse(ArrayUtils.isOneStepFromEdit("pales", "palpr"));
        assertFalse(ArrayUtils.isOneStepFromEdit("pales", "plef"));
    }

    @Test
    public void compressSameTest(){
        assertEquals("a2c", ArrayUtils.compressSame("aac"));
        assertEquals("abc", ArrayUtils.compressSame("abc"));
        assertEquals("ab3c", ArrayUtils.compressSame("abbbc"));
        assertEquals("ab3c2", ArrayUtils.compressSame("abbbcc"));
        assertEquals("ab3cd3", ArrayUtils.compressSame("abbbcddd"));
        assertEquals("ab3cd3a2", ArrayUtils.compressSame("abbbcdddaa"));
        assertEquals("a", ArrayUtils.compressSame("a"));
        assertEquals("a2", ArrayUtils.compressSame("aa"));
    }

}
