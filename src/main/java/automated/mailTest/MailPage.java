package automated.mailTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;


public class MailPage {

    private WebDriver driver;

    public MailPage(WebDriver driver){
        this.driver=driver;
    };

    public void assertUrl(String s) {
        assertTrue(driver.getCurrentUrl().equals(s));
    }

    public void findAndClickByClassName(String s) {
        WebElement writeButton = driver.findElement(By.className(s));
        writeButton.click();
    }

    public void findAndSendByName(String findWhat, String sendWhat) {
        WebElement field = driver.findElement(By.name(findWhat));
        field.sendKeys(sendWhat);
    }

    public void findAndSendByClassName(String findWhat, String sendWhat) {
        WebElement field = driver.findElement(By.className(findWhat));
        field.sendKeys(sendWhat);
    }
}
