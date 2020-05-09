package strings;

import datatypes.strings.OperationsOnBigDigits;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Alexander on 28.07.2017.
 */
public class OperationsOnBigDigitsTests {

    @Test
    public void testSum(){
        assertTrue(OperationsOnBigDigits.sum("5", "6").equals("11"));
        assertTrue(OperationsOnBigDigits.sum("55", "15").equals("70"));
        assertTrue(OperationsOnBigDigits.sum("90", "10").equals("100"));
        assertTrue(OperationsOnBigDigits.sum("96", "4").equals("100"));

        assertTrue(OperationsOnBigDigits.sum("1997", "28978").equals("30975"));

        assertTrue(OperationsOnBigDigits.sum("1234567891011121314151617181920",
                "1234567891011121314151617181920")
                .startsWith("2469135"));
    }


    @Test
    public void testMultiply(){
        //assertTrue(OperationsOnBigDigits.multiply("50", "4").equals("200"));
        assertTrue(OperationsOnBigDigits.multiply("256", "256").equals("65536"));
        assertTrue(OperationsOnBigDigits.multiply("290287121823", "290287121823")!=null);
    }

    @Test
    public void testMultiplyBig(){
        String bigNum = "23434343454557875878765676457843856437563478567465654785634785637856437" +
                "864765746573465734657365375645634536564543656784754837586576576587634786573465763784658764573657365876537456209765" +
                "7846587758437583475873485438567348567836578647563475673465735673856765734653746573465786278627826956457647565765" +
                "57834534657836587629826743657346578645783645786578346573657365786475643756734865736573456736578265782567465746786" +
                "73827584578947584578439579027584975847587587458943785645786856728956485683456846583465843584758364586583465836568" +
                "7584375894789768957876859678956739765867857885934859348598590843095809276867538975689576837598674839567985769875" +
                "564765746765734657384652875648963756743567826574672492865745673485678435687658736457368742657384653478567456746756" +
                "647627867836592305642387965745674856745674563874567823468570646457804325642785674548325634289564387956328745675655";
        assertTrue(OperationsOnBigDigits.multiply(bigNum, bigNum)!=null);
    }

    @Test
    public void testMultiply21(){
        assertTrue(OperationsOnBigDigits.multiply("50", '4').equals("200"));
    }

}
