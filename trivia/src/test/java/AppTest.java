import junit.framework.TestCase;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testStrings()
    {
        String helloString1 = new String("Hello World!");
        String helloString2 = "Hello World!";
        String helloString3 = "Hello World!";
        assertEquals(helloString1, helloString2);
        assertTrue( helloString1 != helloString2);
        assertTrue( "Hello World!" == helloString2);
        assertTrue( helloString3 == helloString2); // because they are reference on the same string from string pool
    }


    public void testInt()
    {
        int int1 = 42;
        Integer int2 = new Integer(42);
        assertTrue( int1 == int2);
    }
}
