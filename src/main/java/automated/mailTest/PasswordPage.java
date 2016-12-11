package automated.mailTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PasswordPage {

    private WebDriver driver;
    WebElement passwordField;

    public PasswordPage(WebDriver driver){
        this.driver=driver;
    };

    public void enterPassword(String s) {
        passwordField = driver.findElement(By.name("Passwd"));
        passwordField.sendKeys(s);
        passwordField.submit();
    }

}
