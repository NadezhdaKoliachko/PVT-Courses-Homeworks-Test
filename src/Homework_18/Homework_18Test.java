package Homework_18;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.sun.deploy.util.VersionString.contains;
import static org.junit.Assert.*;

public class Homework_18Test {
    Homework_18 homework_18 = new Homework_18();
    private static WebDriver driver;
    private WebElement searchField;
    private WebElement guestRooms;
    private WebElement guests;
    private WebElement rooms;
    private String adultsValue;
    private String roomsValue;
    private WebElement plusButton;
    private WebElement minusButton;
    private WebElement checkButton;
    private WebElement amountOfHotels;
    private WebElement dropdown;
    private WebElement sortByRate;
    private WebElement rateOfFirstHotel;

    @Before
    public void preconditions() {
        String exePath = "C:\\Users\\akali\\Downloads\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        driver.get("https://www.booking.com");
        searchField = driver.findElement(By.name("ss"));
        searchField.click();
        searchField.clear();
        searchField.sendKeys("Париж");
        guestRooms = driver.findElement(By.xpath(".//label[@id=\"xp__guests__toggle\"]"));
        guestRooms.click();
        guests = driver.findElement(By.xpath(".//div[@class=\"sb-group__field sb-group__field-adults\"]//div" +
                "[@class=\"bui-stepper__wrapper\"]/span"));
        rooms = driver.findElement(By.xpath(".//div[@class=\"sb-group__field sb-group__field-rooms\"]//div" +
                "[@class=\"bui-stepper__wrapper\"]/span"));
        adultsValue = guests.getText();
        roomsValue = rooms.getText();
        if (Integer.parseInt(adultsValue) < 2) {
            while (Integer.parseInt(adultsValue) < 2) {
                plusButton = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[3]/div[2]/div/div/" +
                        "div[1]/div/div[2]/button[2]/span"));
                plusButton.click();
            }
        } else if (Integer.parseInt(adultsValue) > 2) {
            while (Integer.parseInt(adultsValue) > 2) {
                minusButton = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[3]/div[2]/div/div/" +
                        "div[1]/div/div[2]/button[1]/span"));
                minusButton.click();
            }
        }
        if (Integer.parseInt(roomsValue) > 1) {
            while (Integer.parseInt(adultsValue) > 1) {
                minusButton = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[3]/div[2]/div/div/" +
                        "div[3]/div/div[2]/button[1]/span"));
                minusButton.click();
            }
        }
        checkButton = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button"));
        checkButton.click();
    }

    @Test
    public void hotelsArePresentOnDate() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        amountOfHotels = driver.findElement(By.xpath("//*[@id=\"right\"]/div[3]/div/div/div/h2"));
        Assert.assertTrue(Homework_18.containsHotels(".*[123456789].*", amountOfHotels.getText()));
    }

    @Test
    public void rateOfFirstHotelMoreThen9() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        dropdown = driver.findElement(By.xpath(".//button[@id=\"sortbar_dropdown_button\"]"));
        dropdown.click();
        sortByRate = driver.findElement(By.xpath(".//li[@class=\" sort_category   sort_bayesian_review_score \"]"));
        sortByRate.click();
        Thread.sleep(5000);
        rateOfFirstHotel = driver.findElement(By.xpath(".//div[@class=\"bui-review-score c-score bui-review-score--end\"][1]/div[1]"));
        String convertRateToCorrectFormat = rateOfFirstHotel.getText().replace(",", ".");
        Assert.assertTrue(Homework_18.moreThanNine(Double.parseDouble(convertRateToCorrectFormat)));
    }

    @After
    public void afterTest() {
        driver.close();
    }

}



