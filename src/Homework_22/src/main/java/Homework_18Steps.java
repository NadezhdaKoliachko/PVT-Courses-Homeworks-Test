package Homework_22.src.main.java;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Homework_18Steps {

    private static final String MAIN_URL = "http://booking.com";
    private static final CharSequence CITY = "Paris";
    private static final int GUESTS = 2;
    private static final int ROOMS = 1;
    private Homework_18 homework_18;
    private WebDriver driver;

    public Homework_18Steps() {
        driver = new ChromeDriver();
        homework_18 = new Homework_18(driver);
    }

    @Given("^I am on booking page$")
    public void loadBookingPage() {
        driver.get(MAIN_URL);
    }

    @When("^I choose city, amount of guests and rooms and click Check button")
    public void chooseCityGuestsAndRoomsValues() {
        homework_18.searchFieldInputValue(CITY);
        homework_18.chooseAmountsOfGuestsAndRooms(GUESTS, ROOMS);
        homework_18.clickCheckButton();
    }

    @Then("^I'm on page with founded hotels$")
    public void checkFoundedHotels() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(homework_18.recomendationsArePresent());
    }

    @When("^I check hotels are present on default dates$")
    public boolean checkAreHotelsPresent() {
        return homework_18.containsHotels(".*[123456789].*", homework_18.getAmountOfHotels());
    }

    @Then("^I see amount of hotels > 0$")
    public void checkAmountOfHptelsMoreThanZero() {
        Assert.assertTrue(checkAreHotelsPresent());
    }

    @When("^I click threedots button and choose mark plus feedbacks filter$")
    public void filterHotelsForBestRate() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homework_18.rateSort();
    }

    @Then("^I check rate of first of founded hotels is >= 9$")
    public void checkFirstHotelIsAccordingToConditions() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(homework_18.moreThanNine(Double.parseDouble(homework_18.convertRate())));
    }
}





