package automated.mailTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogOut {

    private WebDriver driver;

    public LogOut(WebDriver driver){
        this.driver=driver;
    };

    public void findAndClickByCSS(String s) {
        WebElement button = driver.findElement(By.cssSelector(s));
       button.click();
    }
}
