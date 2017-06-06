package arraystrings;

import datatypes.arraystrings.ArrayUtils;
import org.junit.Test;

import static junit.framework.TestCase.*;

/**
 * Created by Alexander on 31.05.2017.
 */
public class ArrayStringTests {

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

}
