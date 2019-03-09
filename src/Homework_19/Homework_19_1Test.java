package core;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class Homework_19_1Test {
    private static WebDriver driver = new ChromeDriver();
    private static Homework_19 homework_19 = new Homework_19(driver);
    private static WebElement dates;

    public static void chooseRangeOfDates(int addToCurrentDate, int daysForRest) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, addToCurrentDate);
        String newDate = sdf.format(c.getTime());
        c.add(Calendar.DAY_OF_MONTH, daysForRest);
        String newDate2 = sdf.format(c.getTime());
        dates = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[1]/div[2]/div/div/div/div/span"));
        dates.click();
        String startdateXPath = String.format(".//td[@data-date=\"%s\"]", newDate);
        String endDateXPath = String.format(".//td[@data-date=\"%s\"]", newDate2);
        WebElement startdate = driver.findElement(By.xpath(startdateXPath));
        startdate.click();
        WebElement endDate = driver.findElement(By.xpath(endDateXPath));
        endDate.click();
    }

    @BeforeClass
    public static void preconditions() throws ParseException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.booking.com");
        homework_19.searchFieldInputValue("Париж");
        homework_19.chooseAmountsOfGuestsAndRooms(2, 1);
        //Find dateFrom and dateTo
        chooseRangeOfDates(3, 7);
        homework_19.clickCheckButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homework_19.clickTheMostCheapHotels();
    }

    @Test
    public void testCheapHotels() throws InterruptedException {
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        assertTrue(Homework_19.containsHotels(".*[123456789].*", homework_19.actualHotelsAmountGetText()));
    }

    @Test
    public void testIsPriceInRange() throws InterruptedException {
        Thread.sleep(5000);
        homework_19.sortByRate();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        int[] prices = homework_19.executePricePerDayAndRangeOfPrices(7);
        assertTrue(prices[0] <= prices[2]);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }


}