package steps.bookingTestSteps;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import webDriver.Prop;
import webPages.TrashmailAddressManagerPage;
import webPages.TrashmailIndexPage;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TrashMailSteps {
    WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(TrashMailSteps.class);
    public String createTrashmailAddress(WebDriver driver) throws InterruptedException {
        TrashmailAddressManagerPage trashmailAddressManagerPage=new TrashmailAddressManagerPage(driver);
        trashmailLogin(driver);
        TimeUnit.SECONDS.sleep(20);
        trashmailAddressManagerPage.addEmailClick();
        TimeUnit.SECONDS.sleep(5);
        trashmailAddressManagerPage.saveButtonClick();
        String login=trashmailAddressManagerPage.getLogin();
        String domain=trashmailAddressManagerPage.getDomain();
        String trashmailAdress=login+domain;
        return trashmailAdress;
    }
    public String getTrashmailAddress(WebDriver driver) throws InterruptedException {
        TrashmailAddressManagerPage trashmailAddressManagerPage=new TrashmailAddressManagerPage(driver);
        trashmailLogin(driver);
        TimeUnit.SECONDS.sleep(20);
        String login=trashmailAddressManagerPage.getLogin();
        String domain=trashmailAddressManagerPage.getDomain();
        String trashmailAdress=login+domain;
        return trashmailAdress;
    }
    public void trashmailLogin(WebDriver driver) throws InterruptedException {
        TrashmailIndexPage trashmailIndexPage=new TrashmailIndexPage(driver);
        Properties prop = Prop.getProp();
        driver.get(prop.getProperty("URL_TRASHMAIL"));
        TimeUnit.SECONDS.sleep(5);
        trashmailIndexPage.addressManagerClick();
        TimeUnit.SECONDS.sleep(10);
        trashmailIndexPage.enterLogin(prop.getProperty("USER_NAME"));
        trashmailIndexPage.enterPassword(prop.getProperty("PSW"));
        trashmailIndexPage.signInClick();
    }

    public void trashmailRegistration(WebDriver driver) throws InterruptedException {
        TrashmailIndexPage trashmailIndexPage=new TrashmailIndexPage(driver);
        Properties prop = Prop.getProp();
        driver.get(prop.getProperty("URL_TRASHMAIL"));
        trashmailIndexPage.newUserClick();
        TimeUnit.SECONDS.sleep(3);
        trashmailIndexPage.enterNewLogin(prop.getProperty("USER_NAME"));
        trashmailIndexPage.enterNewPassword(prop.getProperty("PSW"));
        trashmailIndexPage.confirmNewPassword(prop.getProperty("PSW"));
        trashmailIndexPage.enterEmail(prop.getProperty("YA_MAIL"));
        trashmailIndexPage.confirmButtonClick();
    }
}
