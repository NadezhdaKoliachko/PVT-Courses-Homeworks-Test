package core;

import org.junit.Assert;
import org.junit.Ignore;

import static org.junit.Assert.*;

public class MassiveTest {
    Massive ma = new Massive(5, "intArray");
    Object[] array = ma.createArray(6,7,8,9,13);
    Object[] testarray = array;

    @org.junit.Before
    public void setUp() throws Exception {
        System.out.println("prepare test");
    }

    @org.junit.BeforeClass
    public static void beforeClass() {
        System.out.println("start test");
    }

    @org.junit.AfterClass
    public static void afterClass(){
        System.out.println("the end of test");
    }

    @org.junit.After
    public void tearDown() throws Exception {
        System.out.println("end of test");
    }

    @org.junit.Test
    public void createArray() {
        Assert.assertArrayEquals(ma.createArray(6,7,8,9,13), ma.createArray(6,7,8,9,13));
    }

    @org.junit.Test
    public void createArrayTheSameWith() {
        Assert.assertSame(ma.createArray(6,7,8,9,13), testarray);
    }

    @org.junit.Test(expected = NullPointerException.class )
    public void reverseArrayIsNull() {
        Assert.assertNull(ma.reverseArray(ma.createArray(null)));
        }


    @org.junit.Test
    public void reverseArray() {
        Assert.assertArrayEquals(ma.reverseArray(ma.createArray(6,7,8,9,13)), ma.reverseArray(array));
    }


    @org.junit.Test(expected = ArrayIndexOutOfBoundsException.class)
    public void returnOutOfBoundException() {
        Assert.assertNotNull(ma.returnOutOfBoundException(ma.createArray(5,6,7,8)));
    }

    @org.junit.Test
    public void returnFirstElement() {
        Assert.assertEquals(ma.returnFirstElement(ma.createArray(5,6,7,8,9)), ma.returnFirstElement(ma.createArray(5,6,7,8,10)));
    }

    @org.junit.Test
    public void returnLastElement() {
        Assert.assertTrue(ma.returnLastElement(array) == ma.returnLastElement(testarray));
    }

    @Ignore
    @org.junit.Test
    public void returnLastElementFalse() {
        Assert.assertFalse(ma.returnLastElement(array) != ma.returnLastElement(testarray));
    }
}