package automated.mailTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class SentPage {

    @FindBy(css = "div[role='main'] tr:first-child div[role='link'] span:first-child")
    WebElement sentMail;

    private WebDriver driver;

    public SentPage(WebDriver driver){
        this.driver=driver;
    };

    public void assertSend(String assertWhat) {
        assertTrue(sentMail.getText().equals(assertWhat));
    }
    public void waitForIt() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
