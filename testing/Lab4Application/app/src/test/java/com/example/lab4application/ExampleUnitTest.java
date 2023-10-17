package com.example.lab4application;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InOrder;

import java.util.LinkedList;
import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @BeforeClass
    public static void initAll() {
        System.out.println("Before All");
    }
    @Before
    public void init() {
        System.out.println("Before Each");
    }

    @Test
    public void succeedingTest() {
        System.out.println("A succeeding test");

        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        //using mocks
        secondMock.add("was called fourth");
        secondMock.add("was called third");
        firstMock.add("was called first");
        firstMock.add("was called second");


        //create inOrder object passing any mocks that need to be verified in order
        InOrder inOrder = inOrder(firstMock, secondMock);

        //following will make sure that firstMock was called before secondMock
        inOrder.verify(firstMock).add("was called first");
        inOrder.verify(firstMock).add("was called second");
        inOrder.verify(secondMock).add("was called third");
        inOrder.verify(secondMock).add("was called fourth");

    }

    @Test
    public void failingTest() {
        List list = new LinkedList();
        List spy = spy(list);

        //Real method is called and IndexOutOfBoundsException is thrown (list is empty)
        when(spy.get(0)).thenReturn("foo");
        assertEquals("foo", spy.get(0));

        //You have to use doReturn() for stubbing
        doReturn("foo").when(spy).get(0);

    }

    @Test
    @Ignore("for demonstration purposes")
    public void skippedTest() {
        System.out.println("Skipped Test");
    }


    @After
    public void tearDown() {
        System.out.println("After Each");
    }

    @AfterClass
    public static void tearDownAll() {
        System.out.println("After All");
    }
}