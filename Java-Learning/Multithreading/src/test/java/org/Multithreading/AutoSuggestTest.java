package org.Multithreading;

import java.util.List;

import org.multithreading.part3.AutoSuggest;
import org.springframework.beans.factory.annotation.Autowired;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AutoSuggestTest extends TestCase{
	@Autowired
	AutoSuggest autosuggest;
	 /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AutoSuggestTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AutoSuggestTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testResultSizeBasedOnInputFile()
    {
    	List<String> sugg =autosuggest.autoSuggest("af");
        assertTrue( sugg.size()==64 );
    }
}
