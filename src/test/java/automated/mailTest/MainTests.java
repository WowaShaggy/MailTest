package automated.mailTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class MainTests {

    private Data data = new Data();

    @Test
    public void EmailTest() {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//1 Log into your account;

        driver.get(data.loginPage);

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.enterLogin(data.login);

        PasswordPage passwordpage = PageFactory.initElements(driver, PasswordPage.class); ;
        passwordpage.enterPassword(data.password);

//2 Verify that login was successful;

        MailPage mailPage = PageFactory.initElements(driver, MailPage.class);
         mailPage.assertUrl(data.mailPage);

//3 Start creating a new email;

         mailPage.composeCN();

//4 Fill in the fields of addressee, topic and contents of the email;

         mailPage.sendAddressTo(data.login);
         mailPage.sendTopic(data.topic);
         mailPage.sendContents(data.contents);

//5 Save the email in Drafts folder

         mailPage.closeMail();

//6 Navigate to Drafts folder and verify that the email is displayed there;

        DraftsPage draftsPage = PageFactory.initElements(driver, DraftsPage.class);
        driver.get(data.draftsPage);

        draftsPage.waitForClassName();
        draftsPage.waitForIt();

         draftsPage.GetNumberOfMails();
         draftsPage.assertNumberOfMails(data.topic);

//7 View the contents of the email and verify that they correspond to the information, provided during its creation;

        draftsPage.waitForName();
         draftsPage.assertLogin(data.login);
         draftsPage.assertTopic(data.topic);
         draftsPage.assertContents(data.contents);

//8 Send the email;

         draftsPage.sendFromDrafts();

//9 Navigate to Drafts folder and verify that the email is not displayed any more;

        driver.get(data.draftsPage);
        draftsPage.waitForIt();
         draftsPage.assertDraftsNumber();

//10 Navigate to Sent folder and verify that the email is displayed there;

        SentPage sentPage = PageFactory.initElements(driver, SentPage.class);
        driver.get(data.sentPage);
        sentPage.waitForIt();
         sentPage.assertSend(data.topic);

//11 Log out of your account.

        LogOut logOut = PageFactory.initElements(driver, LogOut.class);
         logOut.findButton();
         logOut.leaveAccaunt();
    }
}

