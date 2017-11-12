package com.xixi.Jiansu;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit sqlsession for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the sqlsession case
     *
     * @param testName name of the sqlsession case
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
     * Rigourous SqlSessionFactory :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
