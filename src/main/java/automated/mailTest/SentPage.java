package automated.mailTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

public class SentPage {

    private WebDriver driver;

    public SentPage(WebDriver driver){
        this.driver=driver;
    };

    public void startPage(String s) {
        driver.get(s);
    }
    public void assertByCSS(String findWhat, String assertWhat) {
        WebElement sentMail = driver.findElement(By.cssSelector(findWhat));
        assertTrue(sentMail.getText().equals(assertWhat));
    }


}
