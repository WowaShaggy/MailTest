package automated.mailTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    @FindBy(name = "Email")
    WebElement loginField;

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
    };

    public void enterLogin(String s) {
        loginField.sendKeys(s);
        loginField.submit();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement waitElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("Passwd")));
    }
}
