package strings;

import datatypes.strings.ParenthesesValidCheck;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Alexander on 11.07.2017.
 */
public class ValidParenthesesCheckerTest {

    @Test
    public void test1(){
        assertFalse(ParenthesesValidCheck.checkForValidPrentheses("<(>)"));
        assertTrue(ParenthesesValidCheck.checkForValidPrentheses("(<>)"));
        assertTrue(ParenthesesValidCheck.checkForValidPrentheses("()"));
        assertFalse(ParenthesesValidCheck.checkForValidPrentheses(")("));
        assertFalse(ParenthesesValidCheck.checkForValidPrentheses("<("));
        assertFalse(ParenthesesValidCheck.checkForValidPrentheses("<()"));
    }
}
