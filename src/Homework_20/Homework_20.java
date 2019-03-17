package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Homework_20 {

    public Homework_20(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"mailbox:login\"]")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id=\"mailbox:submit\"]")
    private WebElement continueButton;

    @FindBy(xpath = ".//input[@id= \"mailbox:password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"b-letters\"]/div[1]/div[2]/div/div[2]/div[1]/div/a/div[1]")
    private WebElement checkbox;

    @FindBy(xpath = "//*[@id=\"b-letters\"]/div[1]/div[2]/div/div[2]/div[2]/div/a/div[1]")
    private WebElement checkbox2;

    @FindBy(xpath = "//*[@id=\"b-letters\"]/div[1]/div[2]/div/div[2]/div[3]/div/a/div[1]")
    private WebElement checkbox3;

    @FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[2]/div/div[2]/div[3]/div/span")
    private WebElement relocateToButton;

    @FindBy(xpath = "//*[@id=\":139\"]/div")
    private WebElement spamLink;

    @FindBy(xpath = "//*[@id=\"b-nav_folders\"]/div/div[5]")
    public WebElement spam;

    @FindBy(xpath = "//*[@id=\"b-letters\"]/div[1]/div[5]/div/div[2]/div[1]/div/a/div[1]")
    public WebElement checkboxInSpam;

    @FindBy(xpath = ".//div[@data-name=\"noSpam\"][1]")
    public WebElement notASpamButton;

    @FindBy(xpath = "//*[@id=\"b-toolbar__left\"]/div/div/div[2]/div/a/span")
    private WebElement writeTheLetterButton;

    @FindBy(xpath = ".//textarea[@class=\"js-input compose__labels__input\"][1]")
    private WebElement inputMailsField;

    @FindBy(xpath = ".//input[@class=\"b-input\"]")
    private WebElement topicField;

    @FindBy(xpath = ".//span[@class= \"b-toolbar__btn__text\"][1]")
    private WebElement sendButton;

    @FindBy(id = "tinymce")
    private WebElement textField;

    @FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[2]/div/div[2]/div[5]/div/div[2]/div[1]")
    private WebElement dropdown;

    @FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[2]/div/div[2]/div[5]/div/div[2]/div[2]/a[3]/span[1]")
    private WebElement flagMark;

    @FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[2]/div/div[2]/div[5]/div/div[2]/div[2]/a[4]/span[1]")
    private WebElement removeFlag;

    public void enterEmail(CharSequence email) {
        emailField.click();
        emailField.clear();
        ;
        emailField.sendKeys(email);
    }

    public void enterPassword(CharSequence password) {
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
        continueButton.submit();
    }

    public void tapCheckbox() {
        checkbox.click();
    }

    public void relocateMessageToSpam() {
        relocateToButton.click();
    }

    public void executeMessageFromSpam() {
        spam.click();
        checkboxInSpam.click();
        notASpamButton.click();
    }

    public void sendMessageForGroup(CharSequence... emails) {
        writeTheLetterButton.click();
        inputMailsField.click();
        for (CharSequence item : emails) {
            inputMailsField.sendKeys(item + " ");
        }
    }

    public void textMessageInput(WebDriver driver, CharSequence text) {
        driver.switchTo().frame("toolkit-155284973523445composeEditor_ifr");
        textField.click();
        textField.sendKeys(text);
    }

    public void sendButtonClick() {
        sendButton.click();
    }

    public void markThreeMessagesWithFlags() {
        checkbox.click();
        checkbox2.click();
        checkbox3.click();
        dropdown.click();
        flagMark.click();
    }

    public void removeAllFlags() {
        dropdown.click();
        removeFlag.click();
    }
}
