package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework_19 {
    public Homework_19(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"right\"]/div[4]/div/div/div/h2")
    private WebElement actualHotelsAmount;

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

    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button")
    private WebElement checkButton;

    @FindBy(xpath = "//*[@id=\"sortbar_dropdown_button\"]")
    private WebElement threeDotsButton;

    @FindBy(xpath = "//*[@id=\"sortbar_dropdown_options\"]/li[3]")
    private WebElement sortByRateButton;

    @FindBy(xpath = ".//div[@class=\"js_rackrate_animation_anchor smart_price_style gray-icon  b_bigger_tag   animated\"][1]/strong[1]")
    private WebElement price;

    @FindBy(xpath = "//*[@id=\"filter_price\"]/div[2]/a[2]/div/span[1]")
    private WebElement rangeOfLowPrice;

    @FindBy(xpath = "//*[@id=\"filter_price\"]/div[2]/a[5]/div/span[1]")
    private WebElement rangeOfHighPrice;

    @FindBy(xpath = "//*[@id=\"filter_price\"]/div[2]/a[1]/div/span[1]")
    private WebElement theMostCheapHotels;

    @FindBy(xpath = ".//div[@class=\"sb-group__field sb-group__field-rooms\"]//span[text()= \"+\"]")
    private WebElement plusButtonRooms;

    @FindBy(xpath = ".//div[@class=\"sb-group__field sb-group__field-rooms\"]//span[text()= \"-\"]")
    private WebElement minusButtonRooms;

    @FindBy(xpath = "//*[@id=\"filter_price\"]/div[2]/a[5]/div")
    private WebElement theMostReachHotels;

    @FindBy(xpath = "//*[@id=\"sort_by\"]/ul/li[2]/a")
    private WebElement sortByPriceButton;

    @FindBy(xpath = ".//div[@class= \"sr_gs_rack_rate_and_price\"][1]//b[1]")
    private WebElement cheapFromReachHotels;

    @FindBy(xpath = "//*[@id=\"hotellist_inner\"]/div[1]/div[2]/div[2]/div/div[3]/div/div/a/span")
    private WebElement hotelLink;

    @FindBy(xpath = "//*[@id=\"hprt-form\"]/table/tbody/tr[1]/td[5]/div/label/select")
    private WebElement numbers;

    @FindBy(xpath = "//*[@id=\"booker_title\"]")
    private WebElement checkboxWhoAreYou;

    @FindBy(xpath = "//*[@id=\"firstname\"]")
    private WebElement nameField;

    @FindBy(xpath = "//*[@id=\"lastname\"]")
    private WebElement surnameField;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement email;

    @FindBy(xpath = "//*[@id=\"email_confirm\"]")
    private WebElement confirmEmail;

    @FindBy(xpath = "//*[@id=\"notstayer_false\"]")
    private WebElement radioButton;

    @FindBy(xpath = ".//button[@name= \"book\"]")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"b2bookPage\"]/div[10]/div[1]")
    private WebElement popup;

    @FindBy(xpath = "//*[@id=\"b2bookPage\"]/div[10]/div[1]/div/div/div/div[2]/span")
    private WebElement closeButton;

    @FindBy(xpath = "//*[@id=\"phone\"]")
    private WebElement phoneField;

    @FindBy(xpath = "//*[@id=\"pay-now\"]")
    private WebElement radioBuyNow;

    @FindBy(xpath = "//*[@id=\"cc_type\"]")
    private WebElement cardType;

    @FindBy(xpath = "//*[@id=\"cc_number\"]")
    private WebElement cardNumberField;

    @FindBy(xpath = "//*[@id=\"cc_month\"]")
    private WebElement dateOfCard;

    @FindBy(xpath = "//*[@id=\"cc_cvc\"]")
    private WebElement cvc;

    @FindBy(xpath = "//*[@id=\"bookwrapper_cell\"]/div[4]/div[1]/button[2]/ins/span")
    private WebElement finishBooking;

    @FindBy(xpath = "\"//*[@id=\\\"bookStage3Inc\\\"]/div[3]/div/span\"")
    public WebElement errorAllert;

    @FindBy(xpath = ".//button[@data-tooltip-class= \\\"submit_holder_button_tooltip\\\"]\"")
    private WebElement submitBooking;

    public String actualHotelsAmountGetText() {
        return actualHotelsAmount.getText();
    }

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

    public void clickTheMostCheapHotels() {
        theMostCheapHotels.click();
    }

    public static boolean containsHotels(String pattern, String content) {
        return content.matches(pattern);
    }

    public void sortByRate() throws InterruptedException {
        if (Homework_19.containsHotels(".*[123456789].*", actualHotelsAmount.getText())) {
            threeDotsButton.click();
            sortByRateButton.click();
        }
    }

    public void sortByPrice() {
        sortByPriceButton.click();
    }

    public void clickTheMostReachHotels() {
        theMostReachHotels.click();
    }

    public int executePricesValues(String substring) {
        int price = 0;
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(substring);
        while (m.find()) {
            price = Integer.parseInt(m.group());
        }
        return price;
    }

    public int[] executePricePerDayAndRangeOfPrices(int days) throws InterruptedException {
        int[] array = new int[3];
        String priceString = price.getText();
        int priceValue = Integer.parseInt(priceString.replaceAll("[^0-9]", ""));
        array[0] = priceValue / days;
        String[] rangeOfPrices = splitPriceValues(rangeOfLowPrice, "-");
        array[1] = executePricesValues(rangeOfPrices[0]);
        array[2] = executePricesValues(rangeOfPrices[1]);
        return array;
    }

    public int[] executePricePerDayAndRangeOfPricesForReach(int days) throws InterruptedException {
        int[] array = new int[2];
        String priceString = cheapFromReachHotels.getText();
        int priceValue = Integer.parseInt(priceString.replaceAll("[^0-9]", ""));
        array[0] = priceValue / days;
        String[] rangeOfPrices = splitPriceValues(rangeOfHighPrice, "+");
        array[1] = executePricesValues(rangeOfPrices[0]);
        return array;
    }

    public String[] splitPriceValues(WebElement stringWithPrice, String delimeter) {
        String priceString = stringWithPrice.getText();
        return priceString.split(delimeter);
    }

    public void clickHotelLink() {
        hotelLink.click();
    }

    public void selectNumbers() {
        Select select = new Select(numbers);
        select.selectByValue("1");
    }

    public void fillAllFields(String shortcut, CharSequence name, CharSequence surname, CharSequence mail, CharSequence phone,
                              String card, CharSequence cardNumber, String monthOfCard, CharSequence cVC) throws InterruptedException {
        Select select = new Select(checkboxWhoAreYou);
        select.selectByValue(shortcut);
        nameField.click();
        nameField.sendKeys(name);
        surnameField.click();
        surnameField.sendKeys(surname);
        email.click();
        email.sendKeys(mail);
        phoneField.click();
        phoneField.sendKeys(phone);
        radioBuyNow.click();
        Select selectCard = new Select(cardType);
        selectCard.selectByVisibleText(card);
        Thread.sleep(2000);
        cardNumberField.click();
        cardNumberField.sendKeys(cardNumber);
        Select datesOfCardSelect = new Select(dateOfCard);
        datesOfCardSelect.selectByValue(monthOfCard);
        cvc.click();
        cvc.sendKeys(cVC);
        finishBooking.click();
        Thread.sleep(5000);
    }

    public void clickSubmitBooking() {
        submitBooking.submit();
    }
}








