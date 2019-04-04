import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.awt.windows.WEmbeddedFrame;

import java.sql.SQLException;

public class MailRuRegistrationFormPage {

    public MailRuRegistrationFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public InputFields inputFields = new InputFields();
    @FindBy(xpath = ".//a[@id= \"PH_regLink\"]")
    private WebElement registrationLink;

    @FindBy(xpath = ".//span[@class= \"b-panel__header__text\"]")
    private WebElement registrationPageHeader;

    @FindBy(xpath = ".//input[@name= \"firstname\"]")
    private WebElement firstNameField;

    @FindBy(xpath = ".//input[@name= \"lastname\"]")
    private WebElement lastNameField;

    @FindBy(xpath = ".//input[@data-blockid= \"email_name\"]")
    private WebElement emailNameField;

    @FindBy(xpath = ".//input[@name= \"password\"]")
    private WebElement password;

    @FindBy(xpath = ".//input[@name= \"password_retry\"]")
    private WebElement passwordConfirmField;

    @FindBy(xpath = ".//input[@name= \"phone.phone\"]")
    private WebElement phoneField;

    @FindBy(xpath = ".//button")
    private WebElement registrationButton;

    @FindBy(xpath = ".//div[@data-text= \"Укажите имя\"]")
    private WebElement errorMessageForFirstNameField;

    @FindBy(xpath = ".//div[@data-text= \"Укажите фамилию\"]")
    private WebElement errorMessageForLastNameField;

    @FindBy(xpath = ".//div[@data-text= \"Укажите дату рождения\"]")
    private WebElement errorMessageForDate;

    @FindBy(xpath = "//div[@data-text= \"Укажите ваш пол\"]")
    private WebElement errorMessageForSex;

    @FindBy(xpath = ".//div[@data-text= \"Укажите желаемый почтовый адрес\"]")
    private WebElement errorMessageForEmail;

    @FindBy(xpath = ".//div[@data-text= \"Укажите пароль\"][1]")
    private WebElement errorMessageForMainPasswordField;

    @FindBy(xpath = ".//div[@data-text= \"Укажите пароль\"][2]")
    private WebElement errorMessageForConfirmPasswordField;

    @FindBy(xpath = ".//div[@data-text= \"Укажите телефон\"]")
    private WebElement errorMessageForPhoneField;

    @FindBy(xpath = ".//div[@class= \"b-dropdown__arrow\"][1]")
    private WebElement dayOFDateDropdown;

    @FindBy(xpath = ".//div[@class= \"b-date__month\"]//div[@class=\"b-dropdown__arrow\"][1]")
    private WebElement monthOfDateDropdown;

    @FindBy(xpath = ".//div[@class= \"b-date__year\"]//div[@class= \"b-dropdown__arrow\"][1]")
    private WebElement yearOfDateDropdown;

    @FindBy(xpath = ".//div[@class= \"b-radiogroup__radio-border\"][1]")
    private WebElement menSexRadioButton;

    @FindBy(xpath = "//*[@id=\"undefined_63\"]/div[3]/label/span/div/div[2]")
    private WebElement womenSexRadioButton;

    @FindBy(xpath = ".//label[@id= \"recaptcha-anchor-label\"]")
    private WebElement capture;

    @FindBy(xpath = "//*[@id=\"app-canvas\"]/div/div/div/div[1]/div[3]/form/div[12]/div[2]/a")
    private WebElement userAgreementLicense;

    @FindBy(xpath = ".//div[@class=\"h-header__text\"]")
    private WebElement agreementLicensePageTitle;

    @FindBy(xpath = "//*[@id=\"app-canvas\"]/div/div/div/div[1]/div[3]/form/div[6]/div/div[2]/div[2]/div[5]")
    private WebElement errorEmailMessage;

    @FindBy(xpath = ".//span[@class=\"b-email__name\"]//input[@data-row-name=\"additional_email\"]")
    private WebElement additionalEmailField;

    @FindBy(xpath = ".//div[@data-blockid=\"countries\"]//div[@class=\"b-dropdown__arrow\"][1]")
    private WebElement country;

    @FindBy(xpath = ".//a[@data-text=\"Беларусь\"]")
    private WebElement chooseBelarus;


    public void tapRegistrationLink() {
        registrationLink.click();
    }

    public String getRegistrationPageHeaderText() {
        return registrationPageHeader.getText();
    }

    private void clearField(WebElement element) {
        element.click();
        element.clear();
    }


    public void clearAllFields() {
        clearField(firstNameField);
        clearField(lastNameField);
        clearField(emailNameField);
        clearField(password);
        clearField(passwordConfirmField);
    }

    public void tapRegistrationButton() {
        registrationButton.click();
    }

    public boolean allErrorMessagesAreDisplayed() {
        return errorMessageForFirstNameField.isDisplayed()
                ==
                errorMessageForLastNameField.isDisplayed()
                ==
                errorMessageForDate.isDisplayed()
                ==
                errorMessageForSex.isDisplayed()
                ==
                errorMessageForEmail.isDisplayed()
                ==
                errorMessageForMainPasswordField.isDisplayed();
    }


    public void inputField(CharSequence name, WebElement field) {
        field.click();
        field.clear();
        field.sendKeys(name);
    }

    public void chooseDate(WebDriver driver) {
        String xpathDayPattern = ".//a[@class= \"b-dropdown__list__item day" + InputFields.getDay() + "\"]";
        dayOFDateDropdown.click();
        driver.findElement(By.xpath(xpathDayPattern)).click();
        String xpathMonthPattern = ".//a[@data-text = \"" + InputFields.getMonth() + "\"]";
        monthOfDateDropdown.click();
        driver.findElement(By.xpath(xpathMonthPattern)).click();
        String xpathYearPattern = ".//div[@class= \"b-date__year\"]//a[@data-value= \"" + InputFields.getYear() + "\"]";
        yearOfDateDropdown.click();
        driver.findElement(By.xpath(xpathYearPattern)).click();
    }

    public void chooseSex() {
        menSexRadioButton.click();
    }


    public void userAgreementLinkTap() {
        userAgreementLicense.click();
    }

    public boolean agreementLicenseIsDisplayed() {
        return agreementLicensePageTitle.isDisplayed();
    }

    public void setInputKeysForFields() throws SQLException {
        InputFields.setFirstNameKey((String) SQLConnection.getInstance().sqlConnector().get(0));
        InputFields.setLastNameKey((String) SQLConnection.getInstance().sqlConnector().get(2));
        InputFields.setEmailNameFieldKey((String) SQLConnection.getInstance().sqlConnector().get(3));
        InputFields.setPasswordFieldKey((String) SQLConnection.getInstance().sqlConnector().get(1));
        InputFields.setPhoneFieldKey((String) SQLConnection.getInstance().sqlConnector().get(8));
        InputFields.setDay((String) SQLConnection.getInstance().sqlConnector().get(5));
        InputFields.setMonth((String) SQLConnection.getInstance().sqlConnector().get(6));
        InputFields.setYear((String) SQLConnection.getInstance().sqlConnector().get(7));
        InputFields.setSex(SQLConnection.getInstance().sqlConnector().get(4));
    }

    public void fillAllFieldsCorrectly() {
        inputField(InputFields.getFirstNameKey(), firstNameField);
        inputField(InputFields.getLastNameKey(), lastNameField);
        inputField(InputFields.getEmailNameFieldKey(), emailNameField);
        inputField(InputFields.getPasswordFieldKey(), password);
        inputField(InputFields.getPasswordFieldKey(), passwordConfirmField);
        try {
            if (additionalEmailField.isEnabled()) {
                registrationButton.click();
            }
        } catch (NoSuchElementException e) {
            inputField(InputFields.getPhoneFieldKey(), phoneField);
            registrationButton.click();
        }

    }

    public boolean checkEmailErrorMessage() {
        return errorEmailMessage.isDisplayed();
    }
}


