package Homework_21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homework_18 {

    public Homework_18(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"ss\"]")
    private WebElement searchField;

    @FindBy(xpath = ".//label[@id=\"xp__guests__toggle\"]")
    private WebElement guestRooms;

    @FindBy(xpath = ".//div[@class=\"sb-group__field sb-group__field-adults\"]//span[@class= \"bui-stepper__display\"]")
    private WebElement guests;

    @FindBy(xpath = ".//div[@class=\"sb-group__field sb-group__field-rooms\"]//span[@class= \"bui-stepper__display\"]")
    private WebElement rooms;

    @FindBy(xpath = ".//div[@class=\"sb-group__field sb-group__field-adults\"]//span[text()= \"+\"]")
    private WebElement plusButtonGuests;

    @FindBy(xpath = ".//div[@class=\"sb-group__field sb-group__field-adults\"]//span[text()= \"-\"]")
    private WebElement minusButtonGuests;

    @FindBy(xpath = ".//div[@class=\"sb-group__field sb-group__field-rooms\"]//span[text()= \"+\"]")
    private WebElement plusButtonRooms;

    @FindBy(xpath = ".//div[@class=\"sb-group__field sb-group__field-rooms\"]//span[text()= \"-\"]")
    private WebElement minusButtonRooms;

    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button")
    private WebElement checkButton;

    @FindBy(xpath = "//*[@id=\"right\"]/div[3]/div/div/div/h2")
    private WebElement amountOfHotels;

    @FindBy(xpath = ".//button[@id=\"sortbar_dropdown_button\"]")
    private WebElement dropdown;

    @FindBy(xpath = ".//li[@class=\" sort_category   sort_bayesian_review_score \"]")
    private WebElement sortByRate;

    @FindBy(xpath = ".//div[@class=\"bui-review-score c-score bui-review-score--end\"][1]/div[1]")
    private WebElement rateOfFirstHotel;

    public void searchFieldInputValue(CharSequence city) {
        searchField.click();
        searchField.clear();
        searchField.sendKeys(city);
    }

    public void chooseAmountsOfGuestsAndRooms(int guestsValue, int roomValue) {
        String adultsValue;
        String roomsValue;
        guestRooms.click();
        adultsValue = guests.getText();
        roomsValue = rooms.getText();
        int counter = Integer.parseInt(adultsValue);
        int counter2 = Integer.valueOf(roomsValue);
        setAdultsOrRooms(guestsValue, adultsValue, counter, plusButtonGuests, minusButtonGuests);
        setAdultsOrRooms(roomValue, roomsValue, counter2, plusButtonRooms, minusButtonRooms);
    }

    public void setAdultsOrRooms(int guestsValue, String adultsValue, int counter, WebElement plusButtonGuests, WebElement minusButtonGuests) {
        if (counter < guestsValue) {
            while (counter < guestsValue) {
                counter++;
                plusButtonGuests.click();

            }
        } else if (Integer.parseInt(adultsValue) > guestsValue) {
            while (Integer.parseInt(adultsValue) > guestsValue) {
                counter--;
                minusButtonGuests.click();
            }
        }
    }

    public void clickCheckButton() {
        checkButton.click();
    }

    public String convertRate() {
        return rateOfFirstHotel.getText().replace(",", ".");
    }

    public void rateSort() {
        dropdown.click();
        sortByRate.click();
    }

    public String getAmountOfHotels() {
        return amountOfHotels.getText();
    }

    public boolean containsHotels(String pattern, String content) {
        return content.matches(pattern);
    }

    public boolean moreThanNine(Double rate) {
        return rate >= 9;
    }
}
