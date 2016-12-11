package automated.mailTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MainTests {

    private Data data = new Data();

    @Test
    public void EmailTest() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Wowa\\IdeaProjects\\MailTest\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        ExpectationAndSearch eas = new ExpectationAndSearch(driver);

//1 Log into your account;

        LoginPage loginPage = new LoginPage(driver);
         loginPage.startPage(data.loginPage);
         loginPage.enterLogin(data.login);

        PasswordPage passwordpage = new PasswordPage(driver);
         eas.waitForName(10,"Passwd" );
         passwordpage.enterPassword(data.password);

//2 Verify that login was successful;

         eas.waitForClassName(30,"T-I-KE" );

        MailPage mailPage = new MailPage(driver);
         mailPage.assertUrl(data.mailPage);

//3 Start creating a new email;

         mailPage.findAndClickByClassName("T-I-KE");
         eas.waitForName(50,"to" );

//4 Fill in the fields of addressee, topic and contents of the email;

         mailPage.findAndSendByName("to",data.login);
         mailPage.findAndSendByName("subjectbox",data.topic);
         mailPage.findAndSendByClassName("LW-avf",data.contents);

//5 Save the email in Drafts folder

         mailPage.findAndClickByClassName("Ha");

//6 Navigate to Drafts folder and verify that the email is displayed there;

        DraftsPage draftsPage = new DraftsPage(driver);
         draftsPage.startPage(data.draftsPage);

         eas.waitForClassName(10,"y6" );
         eas.waitForIt(5);

         draftsPage.GetNumberOfMailsByCssSelector("[gh=tm] .Dj .ts:nth-child(3)");
         draftsPage.assertByCSS("div[role='main'] tr:first-child div[role='link'] span:first-child",data.topic );

//7 View the contents of the email and verify that they correspond to the information, provided during its creation;

         eas.waitForName(30,"subjectbox" );
         draftsPage.assertAttributeByClassName("a3q","email",data.login);
         draftsPage.assertAttributeByName("subjectbox","value",data.topic);
         draftsPage.assertTextByClassName("editable",data.contents);

//8 Send the email;

         draftsPage.findAndClickByClassName("aoO");

//9 Navigate to Drafts folder and verify that the email is not displayed any more;

         draftsPage.startPage(data.draftsPage);
         eas.waitForIt(5);
         draftsPage.assertDraftsNumber("[gh=tm] .Dj .ts:nth-child(3)");

//10 Navigate to Sent folder and verify that the email is displayed there;

        SentPage sentPage = new SentPage(driver);
         sentPage.startPage(data.sentPage);
         eas.waitForIt(5);
         sentPage.assertByCSS("div[role='main'] tr:first-child div[role='link'] span:first-child",data.topic);

//11 Log out of your account.

        LogOut logOut = new LogOut(driver);
         logOut.findAndClickByCSS("a[role=button] span");
         logOut.findAndClickByCSS(".gb_xb #gb_71");

    }

}

