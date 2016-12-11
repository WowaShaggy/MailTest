package automated.mailTest;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class DraftsPage {

    private WebDriver driver;

    int numberOfMails;
    int currentNumberOfMails;

    @FindBy(css = "[gh=tm] .Dj .ts:nth-child(3)")
    WebElement dreftsMail;

    @FindBy(css = "div[role='main'] tr:first-child div[role='link'] span:first-child")
    WebElement assertedMail;

    @FindBy(className = "a3q")
    WebElement dreftsLogin;

    @FindBy(name = "subjectbox")
    WebElement dreftsTopic;

    @FindBy(className = "editable")
    WebElement dreftsContents;

    @FindBy(className = "aoO")
    WebElement sendDrafts;

    @FindBy(css = "[gh=tm] .Dj .ts:nth-child(3)")
    WebElement drefts3Mail;


    public DraftsPage(WebDriver driver){
        this.driver=driver;
    };

    public void GetNumberOfMails() {
        numberOfMails = Integer.parseInt(dreftsMail.getText());
    }

    public void assertNumberOfMails( String assertWhat) {
        assertTrue(assertedMail.getText().equals(assertWhat));
        assertedMail.click();
    }

    public void assertLogin( String assertWhat) {
        assertTrue(dreftsLogin.getAttribute("email").equals(assertWhat));
    }

    public void assertTopic( String assertWhat) {
        assertTrue( dreftsTopic.getAttribute("value").equals(assertWhat));
    }

    public void assertContents( String assertWhat) {
        assertTrue(dreftsContents.getText().equals(assertWhat));
    }

    public void sendFromDrafts() {
        sendDrafts.click();
    }

    public void assertDraftsNumber() {
            try{
                currentNumberOfMails= Integer.parseInt(drefts3Mail.getText());
            }
             catch(NoSuchElementException e){
                 currentNumberOfMails=0;
            }
            assertTrue(currentNumberOfMails == numberOfMails-1);

            System.out.println("Количество черновиков До отправки \""   +numberOfMails+"\"");
            System.out.println("Количество черновиков После отправки \""+currentNumberOfMails+"\"");
    }

    public void waitForClassName() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement waitElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("y6")));
    }

    public void waitForName() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement waitElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("subjectbox")));
    }

    public void waitForIt() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
