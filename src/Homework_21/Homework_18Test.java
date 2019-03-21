package Homework_21;

import Homework_21.Homework_18;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Homework_18Test {
    private static WebDriver driver = new ChromeDriver();
    private static Homework_18 homework_18 = new Homework_18(driver);

    @Before
    public void preconditions() throws InterruptedException {
        String exePath = "C:\\Users\\akali\\Downloads\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver.get("https://www.booking.com");
        homework_18.searchFieldInputValue("Paris");
        homework_18.chooseAmountsOfGuestsAndRooms(2, 1);
        homework_18.clickCheckButton();
    }

    @Test
    public void hotelsArePresentOnDate() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(homework_18.containsHotels(".*[123456789].*", homework_18.getAmountOfHotels()));
    }

    @Test
    public void rateOfFirstHotelMoreThen9() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homework_18.rateSort();
        Thread.sleep(5000);
        homework_18.convertRate();
        Assert.assertTrue(homework_18.moreThanNine(Double.parseDouble(homework_18.convertRate())));
    }

    @After
    public void afterTest() {
        driver.close();
    }

}




