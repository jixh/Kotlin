package com.jktaihe.kotlin;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void api(){
        assertNotNull(BuildConfig.API_HOST);
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("in BeforeClass================");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("in AfterClass=================");
    }

    @Before
    public void before() {
        System.out.println("in Before");
    }

    @After
    public void after() {
        System.out.println("in After");
    }

}