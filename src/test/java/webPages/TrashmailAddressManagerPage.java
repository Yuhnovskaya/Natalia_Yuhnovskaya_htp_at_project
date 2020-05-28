package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrashmailAddressManagerPage {

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
        addEmail.click();
    }
    public void saveButtonClick(){
        saveButton.click();
    }
    public String getLogin(){
        String name=login.getText();
        return name;
    }
    public String getDomain(){
        String dom=domain.getText();
        return dom;
    }
}
