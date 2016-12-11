package automated.mailTest;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.assertTrue;

public class DraftsPage {

    private WebDriver driver;

    int numberOfMails;
    int currentNumberOfMails;

    public DraftsPage(WebDriver driver){
        this.driver=driver;
    };

    public void startPage(String s) {
        driver.get(s);
    }

    public void GetNumberOfMailsByCssSelector(String s) {
        WebElement dreftsMail = driver.findElement(By.cssSelector(s));
        numberOfMails = Integer.parseInt(dreftsMail.getText());
    }

    public void assertByCSS(String findWhat, String assertWhat) {
        WebElement dreftsMail = driver.findElement(By.cssSelector(findWhat));
        assertTrue(dreftsMail.getText().equals(assertWhat));
        dreftsMail.click();
    }

    public void assertAttributeByClassName(String findWhat, String fromWhat, String assertWhat) {
        WebElement dreftsMail = driver.findElement(By.className(findWhat));
        assertTrue(dreftsMail.getAttribute(fromWhat).equals(assertWhat));
    }

    public void assertAttributeByName(String findWhat, String fromWhat, String assertWhat) {
        WebElement dreftsMail = driver.findElement(By.name(findWhat));
        assertTrue(dreftsMail.getAttribute(fromWhat).equals(assertWhat));
    }

    public void assertTextByClassName(String findWhat, String assertWhat) {
        WebElement dreftsMail = driver.findElement(By.className(findWhat));
        assertTrue(dreftsMail.getText().equals(assertWhat));
    }

    public void findAndClickByClassName(String s) {
        WebElement dreftsMail = driver.findElement(By.className(s));
        dreftsMail.click();
    }

    public void assertDraftsNumber(String s) {
            try{
                WebElement drefts3Mail = driver.findElement(By.cssSelector(s));
                currentNumberOfMails= Integer.parseInt(drefts3Mail.getText());
            }
             catch(NoSuchElementException e){
                 currentNumberOfMails=0;
            }
            assertTrue(currentNumberOfMails == numberOfMails-1);

            System.out.println("Количество черновиков До отправки \""   +numberOfMails+"\"");
            System.out.println("Количество черновиков После отправки \""+currentNumberOfMails+"\"");
    }
}
