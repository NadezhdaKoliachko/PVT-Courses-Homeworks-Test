import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;


@Log4j
public class MailRuLoginFormSteps {

    private static final Logger logger = Logger.getLogger(MailRuRegistrationFormSteps.class);

    private MailRuLoginFormPage mailRuLoginFormPage;
    private WebDriver driver;

    public MailRuLoginFormSteps() {
        driver = new ChromeDriver();
        mailRuLoginFormPage = new MailRuLoginFormPage(driver);
    }


    @Given("^I go on mail.ru page$")
    public void goToMainPage() {
        driver.get("https://www.mail.ru");
        log.info("Check login flow");
    }


    @When("^I enter correct credentials and tap \"Войти\"$")
    public void fillLoginFields() throws InterruptedException, SQLException, ParserConfigurationException, SAXException, IOException {
        mailRuLoginFormPage.setKeysForFields();
        mailRuLoginFormPage.sendKeysIntoLoginFields();
        mailRuLoginFormPage.tapLoginButton();
        log.info("Successfull login");
    }


    @Then("^I can open user account$")
    public void userAccountIsEnabled() throws InterruptedException {
        try {
            (new WebDriverWait(driver, 1000)).
                    until(ExpectedConditions.elementToBeClickable(mailRuLoginFormPage.getUserLink()));
            Assert.assertTrue(mailRuLoginFormPage.getUserLink().isDisplayed());
        } catch (StaleElementReferenceException e) {
            driver.close();
        }
        log.info("See user account");
    }


    @When("^I input correct email and wrong password and tap \"Войти\" button$")
    public void fillCorrectEmailWrongPassword() throws SQLException, ParserConfigurationException, SAXException, IOException {
        mailRuLoginFormPage.setKeysForFields();
        InputFields.setLoginPasswordField("f");
        mailRuLoginFormPage.sendKeysIntoLoginFields();
        mailRuLoginFormPage.tapLoginButton();
        log.info("Login with wrong password");
    }


    @Then("^I see error message$")
    public void checkErrorMessage() {
        (new WebDriverWait(driver, 1000)).
                until(ExpectedConditions.elementToBeClickable(mailRuLoginFormPage.getMailBoxError()));
        Assert.assertTrue(mailRuLoginFormPage.getMailBoxError().isDisplayed());
        driver.close();
        log.info("See error message");
    }


    @When("^I input wrong email and correct password and tap \"Войти\" button$")
    public void fillWrongEmailAndCorrectPassword() throws SQLException, ParserConfigurationException, SAXException, IOException {
        mailRuLoginFormPage.setKeysForFields();
        InputFields.setLoginEmailField("fghjtyu@gmail.com");
        mailRuLoginFormPage.sendKeysIntoLoginFields();
        mailRuLoginFormPage.tapLoginButton();
        log.info("Login with wrong email");
    }


    @Then("^I see forgot password link$")
    public void checkForgotLinkIsVisible() {
        (new WebDriverWait(driver, 1000)).
                until(ExpectedConditions.elementToBeClickable(mailRuLoginFormPage.getForgotPasswordLink()));
        Assert.assertTrue(mailRuLoginFormPage.getForgotPasswordLink().isDisplayed());
        driver.close();
    }


    @When("^I input wrong email and password and tap \"Войти\" button$")
    public void fillWrongEmailAndPassword() {
        InputFields.setLoginEmailField("fghjtyu@gmail.com");
        InputFields.setLoginPasswordField("1");
        mailRuLoginFormPage.sendKeysIntoLoginFields();
        mailRuLoginFormPage.tapLoginButton();
        log.info("Login with wrong email");
    }


    @Then("^I see captcha$")
    public void checkUserIsntLogedIn() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("https://e.mail.ru"));
        driver.close();
        log.info("See capture");
    }


    @When("^I tap \"Забыли пароль\" link$")
    public void tapForgotPasswordLink() {
        mailRuLoginFormPage.tapForgotPasswordLink();
        log.info("Tap forgot password link");
    }


    @Then("^I check user redirected on correct page$")
    public void checkUserRedirectedToCorrectPage() throws InterruptedException {
        Thread.sleep(3000);
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("https://e.mail.ru/password/restore/"));
        driver.close();
        log.info("User redirected to correct page");
    }


    @When("^I input correct credentials and tap \"Remember me\" checkbox and tap \"Войти\" button$")
    public void checkUserWasRememberdBySystem() throws SQLException, ParserConfigurationException, SAXException, IOException {
        mailRuLoginFormPage.setKeysForFields();
        mailRuLoginFormPage.sendKeysIntoLoginFields();
        mailRuLoginFormPage.tapLoginButton();
        log.info("Check remember me checkbox");
    }


    @When("^I make logout$")
    public void makeLogOut() {
        (new WebDriverWait(driver, 1000)).
                until(ExpectedConditions.elementToBeClickable(mailRuLoginFormPage.getLogoutLink()));
        mailRuLoginFormPage.tapLogoutLink();
        log.info("Make logout");
    }


    @Then("^I check email field isn't empty$")
    public void checkEmailFieldIsntEmpty() {
        System.out.println(mailRuLoginFormPage.getInputEmailField().getText());
        Assert.assertTrue(mailRuLoginFormPage.getInputEmailField().getText().contains(InputFields.getLoginEmailField()));
        driver.close();
        log.info("Check user was remembered");
    }


}








