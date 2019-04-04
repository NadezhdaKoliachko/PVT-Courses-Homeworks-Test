
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

@Log4j
public class MailRuRegistrationFormSteps {

    private static final String MAIN_URL = "http://mail.ru";
    private MailRuRegistrationFormPage mailRuRegistrationFormPage;
    private WebDriver driver;

    public MailRuRegistrationFormSteps() {
        driver = new ChromeDriver();
        mailRuRegistrationFormPage = new MailRuRegistrationFormPage(driver);
    }

    @Given("^I am on mail.ru page$")
    public void loadMainPage() {
        driver.get(MAIN_URL);
        log.info("Check registration flow");
    }

    @When("^I tap registration link$")
    public void goToRegistrationPage() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        mailRuRegistrationFormPage.tapRegistrationLink();
        log.info("Tap registration link");
    }

    @Then("^I am on registration page$")
    public void checkUserOnRegistrationPage() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertTrue(mailRuRegistrationFormPage.getRegistrationPageHeaderText().contains("Регистрация"));
        log.info("Successfull redirect");
    }

    @When("^I clear all fields and tap \"Зарегистрироваться\" button$")
    public void clearAllFieldsAndTapSaveButton() {
        mailRuRegistrationFormPage.clearAllFields();
        mailRuRegistrationFormPage.tapRegistrationButton();
        log.info("Regitration with all empty fields");
    }

    @Then("^I check error messages near all fields$")
    public void checkErrorMessagesNearAllFields() {
        Assert.assertTrue(mailRuRegistrationFormPage.allErrorMessagesAreDisplayed());
        driver.close();
        log.info("Error messages near all fields");
    }

    @When("^I fill all fields with correct data and tap \"Зарегистрироваться\"$")
    public void fillAllFieldsWithCorrectData() throws SQLException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mailRuRegistrationFormPage.setInputKeysForFields();
        mailRuRegistrationFormPage.chooseDate(driver);
        mailRuRegistrationFormPage.fillAllFieldsCorrectly();
        mailRuRegistrationFormPage.chooseSex();
        log.info("Successfull registration");
    }

    @Then("^I see capture$")
    public void checkUserSeeCapture() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        if (driver.getCurrentUrl().equals("https://account.mail.ru/signup/verify")) {
            Assert.assertEquals("https://account.mail.ru/signup/verify", driver.getCurrentUrl());
            driver.close();
        } else if (driver.getCurrentUrl().equals("https://account.mail.ru/verify/simple")) {
            Assert.assertEquals("https://account.mail.ru/verify/simple", driver.getCurrentUrl());
            driver.close();
        }
        log.info("See capture");

    }

    @When("^I tap end-user license agreement link$")
    public void tapLicenseLink() {

        mailRuRegistrationFormPage.userAgreementLinkTap();
        log.info("Tap user license agreement");
    }

    @Then("^I am on page with end-user license agreement$")
    public void checkAgreementLicenseIsDisplayed() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        Assert.assertTrue(mailRuRegistrationFormPage.agreementLicenseIsDisplayed());
        driver.close();
        log.info("Successfull redirect to user-license agreement page");
    }

    @When("^I input wrong email data in email input field, fill other fields correctly and tap \"Зарегистрироваться\"$")
    public void fillAllFieldsExceptEmail() throws SQLException {
        mailRuRegistrationFormPage.setInputKeysForFields();
        InputFields.setEmailNameFieldKey("4567ffhf^&**");
        mailRuRegistrationFormPage.chooseDate(driver);
        mailRuRegistrationFormPage.chooseSex();
        mailRuRegistrationFormPage.fillAllFieldsCorrectly();
        log.info("Registration with wrong email");
    }

    @Then("^I see error message for email input field$")
    public void checkUserSeeErrorMessageForWrongEmail() {
        Assert.assertTrue(mailRuRegistrationFormPage.checkEmailErrorMessage());
        driver.close();
        log.info("Error message for wrong email is displayed ");
    }

    @When("^I choose min values for day, month and year and tap \"Зарегистрироваться\"$")
    public void fillAllFieldsCorrectlyAndSetMinDate() throws SQLException {
        mailRuRegistrationFormPage.setInputKeysForFields();
        InputFields.setDay("1");
        InputFields.setMonth("Январь");
        InputFields.setYear("1901");
        mailRuRegistrationFormPage.chooseDate(driver);
        mailRuRegistrationFormPage.chooseSex();
        mailRuRegistrationFormPage.fillAllFieldsCorrectly();
        log.info("Registration with min date");
    }

    @When("^I choose max values for day, month and year and tap \"Зарегистрироваться\"")
    public void fillAllFieldsCorrectlyAndSetMaxDate() throws SQLException {
        mailRuRegistrationFormPage.setInputKeysForFields();
        InputFields.setDay("31");
        InputFields.setMonth("Декабрь");
        InputFields.setYear("2019");
        mailRuRegistrationFormPage.chooseDate(driver);
        mailRuRegistrationFormPage.chooseSex();
        mailRuRegistrationFormPage.fillAllFieldsCorrectly();
        log.info("Registration with max date");
    }
}





