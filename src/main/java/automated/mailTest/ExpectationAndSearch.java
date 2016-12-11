package automated.mailTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ExpectationAndSearch {

    private static WebDriver driver;

    public ExpectationAndSearch(WebDriver driver){
        this.driver=driver;
    };

    public static void waitForName(int i, String s) {
        WebDriverWait wait = new WebDriverWait(driver, i);
        WebElement waitElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name(s)));
    }

    public static void waitForClassName(int i, String s) {
        WebDriverWait wait = new WebDriverWait(driver, i);
        WebElement waitElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className(s)));
    }

    public static void waitForIt(int i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
