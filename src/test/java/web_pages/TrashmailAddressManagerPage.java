package web_pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class TrashmailAddressManagerPage {
    private static final Logger LOGGER = LogManager.getLogger(TrashmailAddressManagerPage.class);

    @FindBy(xpath = "//*[@id='fe-add-btnIconEl']")
    private WebElement addEmail;
    @FindBy(xpath = "//*[@id='fe-save-btnEl']")
    private WebElement saveButton;
    @FindBy(xpath = "//*[contains(@class,'disposable-name')]/div")
    private WebElement login;
    @FindBy(xpath = "//*[contains(@class,'disposable-domain')]/div")
    private WebElement domain;

    public TrashmailAddressManagerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void addEmailClick(){
        addEmail.click();
        LOGGER.debug("The method clicks Webelement addEmail");
    }
    public void saveButtonClick(){
        saveButton.click();
        LOGGER.debug("The method clicks Webelement saveButton");
    }
    public String getLogin(){
        String name=login.getText();
        LOGGER.debug("The method returns text in the Webelement login");
        return name;
    }
    public String getDomain(){
        String dom=domain.getText();
        LOGGER.debug("The method returns text in the Webelement domain");
        return dom;
    }
    public String createTrashmailAddress() throws InterruptedException {
        addEmailClick();
        TimeUnit.SECONDS.sleep(5);
        saveButtonClick();
        String login=getLogin();
        String domain=getDomain();
        String trashmailAdress=login+domain;
        LOGGER.debug("The method create temporary TrashMail address");
        return trashmailAdress;
    }
    public String getTrashmailAddress() throws InterruptedException {
        String login=getLogin();
        String domain=getDomain();
        String trashmailAddress=login+domain;
        LOGGER.debug("The method returns temporary TrashMail address");
        return trashmailAddress;
    }
}
