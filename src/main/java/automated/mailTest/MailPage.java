package automated.mailTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

public class MailPage {

    @FindBy(className= "T-I-KE")
    WebElement writeButton;

    @FindBy(className= "Ha")
    WebElement closeButton;

    @FindBy(name= "to")
    WebElement fieldTo;

    @FindBy(name= "subjectbox")
    WebElement fieldTopic;

    @FindBy(className= "LW-avf")
    WebElement fieldContent;

    private WebDriver driver;

    public MailPage(WebDriver driver){
        this.driver=driver;
    };

    public void assertUrl(String s) {
        assertTrue(driver.getCurrentUrl().equals(s));
    }

    public void composeCN() {
        writeButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 50);
        WebElement waitElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("to")));
    }

    public void closeMail() {
        closeButton.click();
    }

    public void sendAddressTo(String sendWhat) {
        fieldTo.sendKeys(sendWhat);
    }

    public void sendTopic( String sendWhat) {
        fieldTopic.sendKeys(sendWhat);
    }

    public void sendContents( String sendWhat) {
        fieldContent.sendKeys(sendWhat);
    }
}
