package core;

import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class MassiveForTestNGTest {
    MassiveForTestNG massiveForTestNG = new MassiveForTestNG(5, "TestNGmassive");
    private Object array;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("before suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("after suite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("before class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("after class");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("before groups");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("after groups");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("before method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("after method");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("before test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("after test");
    }

    @DataProvider(name = "dataForCreateArrayMethod")
    public Object[][] createData() {
        Object[] arrayActual1 = {1, 2, 3, 4, 5};
        Object[] arrayExpected2 = {5, 2, 3, 4, 1};
        Object[] arrayActual3 = {-1, -2, -3, -4, -7};
        Object[] arrayExpected4 = {-7, -3, -2, -4, -1};
        return new Object[][]{
                {arrayActual1, arrayExpected2},
                {arrayActual3, arrayExpected4}
        };
    }

    @Test(alwaysRun = true, dataProvider = "dataForCreateArrayMethod")
    public void testCreateArray(Object[] actual, Object[] expected) {
        Assert.assertEqualsNoOrder(actual, expected);
    }

    @Test(groups = "NotCreateMethodTests")
    public void testAssertNotSameCreateArray() {
        Assert.assertNotSame(massiveForTestNG.createArray(1, 2, 3, 4, 5), massiveForTestNG.createArray(1, 2, 3, 4, 5));
    }

    @Test(timeOut = 1)
    public void testReverseArray() {
        Assert.assertEquals(massiveForTestNG.reverseArray(massiveForTestNG.createArray(1, 2, 3, 4, 5)),
                massiveForTestNG.reverseArray(massiveForTestNG.createArray(1, 2, 3, 4, 5)));
    }

    @Test
    public void testAssertSameReverseArray() {
        Assert.assertSame(massiveForTestNG.reverseArray(massiveForTestNG.createArray(1, 2, 3, 4, 5)),
                massiveForTestNG.reverseArray(massiveForTestNG.createArray(1, 2, 3, 4, 5)));
    }

    @Test(expectedExceptions = ArrayIndexOutOfBoundsException.class)
    public void testReturnOutOfBoundException() {
        massiveForTestNG.returnOutOfBoundException(massiveForTestNG.createArray(1, 2, 3, 4, 5));
    }

    @Test(enabled = false)
    public void testReturnFirstElement() {
        Assert.assertNull(massiveForTestNG.returnFirstElement(massiveForTestNG.createArray(1, 2, 3, 4, 5)));
    }

    @Test
    public void testAssertSameReturnFirstElement() {
        Assert.assertSame(massiveForTestNG.returnFirstElement(massiveForTestNG.createArray(1, 2, 3, 4, 5)),
                massiveForTestNG.returnFirstElement(massiveForTestNG.createArray(1, 2, 3, 4, 5)));
    }

    @Test(groups = "NotCreateMethodTests")
    public void testReturnLastElement() {
        Assert.assertEquals(massiveForTestNG.returnLastElement(massiveForTestNG.createArray(1, 2, 3, 4, 5)),
                massiveForTestNG.returnLastElement(massiveForTestNG.createArray(1, 2, 3, 4, 5)));
    }

    @Test
    public void testAssertNotEqualsReturnLastElement() {
        Assert.assertNotEquals(massiveForTestNG.returnLastElement(massiveForTestNG.createArray("ghgj", "gk", "gklk",
                "gkhk", "hmhm")),
                massiveForTestNG.returnLastElement(massiveForTestNG.createArray(1, 2, 3, 4, 5)));
    }

    @Test
    public void testReturnMassiveSize() {
        Assert.assertEquals(massiveForTestNG.returnMassiveSize(massiveForTestNG.createArray(1, 2, 3, 4, 5)),
                massiveForTestNG.returnMassiveSize(massiveForTestNG.createArray(5, 6, 7, 8, 9)));
    }

    @Test(groups = "NotCreateMethodTests")
    public void testAssertTrueReturnMassiveSize() {
        Assert.assertFalse(massiveForTestNG.returnMassiveSize(massiveForTestNG.createArray(1, 2, 3, 4, 5)) >
                massiveForTestNG.returnMassiveSize(massiveForTestNG.createArray(5, 6, 7, 8, 9)));
    }

    @Test(groups = "NotCreateMethodTest", dataProvider = "dataForCreateArrayMethod")
    public void testSortArray(Object[] first, Object[] second) {
        Assert.assertEquals(massiveForTestNG.sortArray(first), massiveForTestNG.sortArray(second));
    }

    @Test
    public void testArrayToString() {
        Assert.assertEquals(massiveForTestNG.arrayToString(massiveForTestNG.createArray(1, 2, 3, 4, 9)),
                massiveForTestNG.arrayToString(massiveForTestNG.createArray(1, 2, 3, 4, 9)));
    }

    @Test
    public void testArrayAsList() {
        Assert.assertNotEquals(massiveForTestNG.arrayAsList(massiveForTestNG.createArray("gjjh", "gh", "gfgkg",
                "gklk", "hyhk")),
                massiveForTestNG.arrayAsList(massiveForTestNG.createArray("hlmkh", "gjtghj", "kmgj", "ghj", "jkgj")));
    }
}