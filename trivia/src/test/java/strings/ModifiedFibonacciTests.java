package strings;

import datatypes.strings.ModifiedFibonacci;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Alexander on 28.07.2017.
 */
public class ModifiedFibonacciTests {

    @Test
    public void test(){
        assertTrue( ModifiedFibonacci.calculate(0,1,5).equals("5"));
        assertTrue( ModifiedFibonacci.calculate(0,1,6).equals("27"));
        assertTrue( ModifiedFibonacci.calculate(0,1,10).equals("84266613096281243382112"));
        assertTrue( ModifiedFibonacci.calculate(2,0,12)
                .equals("104292047421056066715537698951727494083004264929891558279344228228718658019003171882044298756195662458280101226593033166933803327203745068186400974453022429724308"));
    }

}
