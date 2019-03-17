package core;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Beta;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class Homework_20Test {

    private static WebDriver driver = new ChromeDriver();
    ;
    private static Homework_20 homework_20 = new Homework_20(driver);

    @Before
    public void preconditions() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.mail.ru");
        homework_20.enterEmail("nkolyachko@bk.ru");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        homework_20.enterPassword("krasnietulpani1");
    }

    @Test
    public void oneMessageToSpam() {
        homework_20.tapCheckbox();
        homework_20.relocateMessageToSpam();
    }

    @Test
    public void executeMessageFromSpam() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homework_20.spam.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homework_20.checkboxInSpam.click();
        homework_20.notASpamButton.click();
    }
    /*Driver cannot find iframe name:(
    @Test
    public void sendMesssageToGroupOfUsers() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.mail.ru");
        homework_20.enterEmail("nkolyachko@bk.ru");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        homework_20.enterPassword("krasnietulpani1");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        homework_20.sendMessageForGroup("jjfhgfjg@mail.ru", "fjhf@gmail.com");
        homework_20.textMessageInput(driver,"Hi, guys!");
        homework_20.sendButtonClick();
    }
    */

    @Test
    public void markThreeMessagesWithFlags() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homework_20.markThreeMessagesWithFlags();
    }

    @Test
    public void removeFlagsFromThreeMessages() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homework_20.markThreeMessagesWithFlags();
        homework_20.removeAllFlags();
    }


    public void tearDown() throws Exception {
        driver.close();
    }
}