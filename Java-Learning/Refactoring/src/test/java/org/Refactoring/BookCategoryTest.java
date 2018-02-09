package org.Refactoring;

import org.springframework.beans.factory.annotation.Autowired;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BookCategoryTest extends TestCase{
	@Autowired
	BookFactory bookFactory;
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public BookCategoryTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( BookCategoryTest.class );
    }

    /*
     * Rigourous Test :-)
     */
    public void testIfFactoryProducesExpectedFictionBookObject() throws Exception
    {
        assertTrue(bookFactory.getBook(BookCategory.FICTION) instanceof Fiction);
    }
    
    public void negativeTestIfFactoryProducesExpectedFictionBookObject() throws Exception
    {
        assertFalse(bookFactory.getBook(BookCategory.CHILDRENS) instanceof Fiction);
    }
}
