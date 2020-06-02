package webPages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.bookingTestSteps.BookingSteps;

public class TrashmailAddressManagerPage {
    private static final Logger LOGGER = LogManager.getLogger(TrashmailAddressManagerPage.class);

    @FindBy(xpath = "//*[@id=\"fe-add-btnIconEl\"]")
    private WebElement addEmail;
    @FindBy(xpath = "//*[@id=\"fe-save-btnEl\"]")
    private WebElement saveButton;
    @FindBy(xpath = "//*[contains(@class,'disposable-name')]/div")
    private WebElement login;
    @FindBy(xpath = "//*[contains(@class,'disposable-domain')]/div")
    private WebElement domain;

    public TrashmailAddressManagerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void addEmailClick(){
        LOGGER.debug("The method clicks Webelement addEmail");
        addEmail.click();
    }
    public void saveButtonClick(){
        LOGGER.debug("The method clicks Webelement saveButton");
        saveButton.click();
    }
    public String getLogin(){
        LOGGER.debug("The method returns text in the Webelement login");
        String name=login.getText();
        return name;
    }
    public String getDomain(){
        LOGGER.debug("The method returns text in the Webelement domain");
        String dom=domain.getText();
        return dom;
    }
}
