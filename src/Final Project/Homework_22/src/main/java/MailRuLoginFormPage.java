import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.xml.sax.SAXException;
import runner.Runner;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;


public class MailRuLoginFormPage {

    public MailRuLoginFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//input[@id=\"mailbox:login\"]")
    private WebElement inputEmailField;

    @FindBy(xpath = ".//input[@id=\"mailbox:password\"]")
    private WebElement inputPasswordField;

    @FindBy(xpath = ".//label[@id=\"mailbox:submit\"]")
    private WebElement submitButton;

    @FindBy(xpath = ".//i[@class=\"x-ph__menu__button__text x-ph__menu__button__text_auth\"]")
    private WebElement userLink;

    @FindBy(xpath = ".//div[@id=\"mailbox:error\"]")
    private WebElement mailBoxError;

    @FindBy(xpath = ".//a[@id=\"restore\"]")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = ".//a[@id=\"PH_logoutLink\"]")
    private WebElement logoutLink;

    public WebElement getLogoutLink() {
        return logoutLink;
    }

    public WebElement getForgotPasswordLink() {
        return forgotPasswordLink;
    }

    public WebElement getMailBoxError() {
        return mailBoxError;
    }

    public WebElement getUserLink() {
        return userLink;
    }

    public WebElement getInputEmailField() {
        return inputEmailField;
    }

    public void setInputEmailField(WebElement inputEmailField) {
        this.inputEmailField = inputEmailField;
    }

    public WebElement getInputPasswordField() {
        return inputPasswordField;
    }

    public void setInputPasswordField(WebElement inputPasswordField) {
        this.inputPasswordField = inputPasswordField;
    }

    public void inputField(CharSequence name, WebElement field) {
        field.click();
        field.clear();
        field.sendKeys(name);
    }

    public void setKeysForFields() throws SQLException, IOException, SAXException, ParserConfigurationException {
        InputFields.setLoginEmailField(Runner.getInstance().parseXML().get(0));
        InputFields.setLoginPasswordField(Runner.getInstance().parseXML().get(1));

    }

    public void sendKeysIntoLoginFields() {
        inputField(InputFields.getLoginEmailField(), getInputEmailField());
        inputField(InputFields.getLoginPasswordField(), getInputPasswordField());
    }

    public void tapLoginButton() {
        submitButton.click();
    }

    public void tapForgotPasswordLink() {
        forgotPasswordLink.click();
    }

    public void tapLogoutLink() {
        logoutLink.click();
    }


}
