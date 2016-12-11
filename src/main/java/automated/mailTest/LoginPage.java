package automated.mailTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;
    WebElement loginField;

    public LoginPage(WebDriver driver){
        this.driver=driver;
    };

    public void startPage(String s) {
        driver.get(s);
    }

    public void enterLogin(String s) {
        loginField = driver.findElement(By.name("Email"));
        loginField.sendKeys(s);
        loginField.submit();
    }
}
