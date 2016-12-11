package automated.mailTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordPage {

    @FindBy(name = "Passwd")
    WebElement passwordField;

    private WebDriver driver;

    public PasswordPage(WebDriver driver){
        this.driver=driver;
    };

    public void enterPassword(String s) {
        passwordField.sendKeys(s);
        passwordField.submit();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement waitElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("T-I-KE")));
    }

}
