package core;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class Homework_19_2_3Test {
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
        homework_19.chooseAmountsOfGuestsAndRooms(4, 2);
        //Find dateFrom and dateTo
        chooseRangeOfDates(3, 7);
        homework_19.clickCheckButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homework_19.clickTheMostReachHotels();
    }

    @Test
    public void testIsPriceInRange() throws InterruptedException {
        Thread.sleep(5000);
        homework_19.sortByPrice();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        int[] prices = homework_19.executePricePerDayAndRangeOfPricesForReach(7);
        assertTrue(prices[0] >= prices[1]);
    }

    @Test
    public void testBookingWithWrongCardNumber() throws InterruptedException {
        Thread.sleep(5000);
        homework_19.sortByPrice();
        Thread.sleep(5000);
        homework_19.clickHotelLink();
        Set<String> windows = driver.getWindowHandles();
        for (String winHandle : windows) {
            driver.switchTo().window(winHandle);
        }
        Thread.sleep(5000);
        if (driver.findElement(By.xpath("//*[@id=\"hotelTmpl\"]/div[5]")).isDisplayed()) {
            driver.findElement(By.xpath(".//div[@class = \"et-survey hide_this_for_print\"]//span")).click();
        }
        homework_19.selectNumbers();
        homework_19.clickSubmitBooking();
        homework_19.fillAllFields("ms", "Nadezhda", "Koliachko",
                "nadezhda.kosareva95@gmail.com", "257427218", "Visa",
                "4242 4242 4242 4242", "04", "123");
        Assert.assertTrue(homework_19.errorAllert.isDisplayed());
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
