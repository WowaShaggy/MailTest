package automated.mailTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOut {

    @FindBy(css = "a[role=button] span")
    WebElement button;

    @FindBy(css = ".gb_xb #gb_71")
    WebElement leave;

    private WebDriver driver;

    public LogOut(WebDriver driver){
        this.driver=driver;
    };

    public void findButton() {
       button.click();
    }

    public void leaveAccount() {
        leave.click();
    }
}
