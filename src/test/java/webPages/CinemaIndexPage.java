package webPages;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.bookingTestSteps.BaseSteps;

import java.util.concurrent.TimeUnit;

public class CinemaIndexPage {
    static WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(CinemaIndexPage.class);
    String film_i_xpath = "//*[@id='root']/div[1]/div[1]/div[3]/div[2]/div[%s]/div[1]/div/a/span";
    String description_xpath = "//*[@class='sc-TPgYF jipAap']/span";
    @FindBy(xpath = "//*[@id=\"root\"]/header/div/div/div/div[3]/div[2]/div[3]/div[3]/div[1]")
    public WebElement searchIcon;
    @FindBy(xpath = "//*[@class='sc-gzVnrw kpyERI']")
    public WebElement searchField;
    @FindBy(xpath = "//*[@class='sc-dUZuEM loEZjI']")
    public WebElement filmsList;
    @FindBy(xpath = "//*[@class='sc-htoDjs jJISGf']")
    public WebElement filmsNumber;
    @FindBy(xpath = "//*[@class='sc-fyjhYU eVJmYW']")
    public WebElement login;
    @FindBy(xpath = "//*[@type='email']")
    public WebElement email;
    @FindBy(xpath = "//*[@type='password']")
    public WebElement password;
    @FindBy(xpath = "//*[@class='sc-fyjhYU eVJmYW']")
    public WebElement level;
    @FindBy(xpath = "//*[@class='sc-hqFvvW gGBuI']")
    public WebElement messsage;
    @FindBy(xpath = "//*[@class='sc-gbOuXE fbspKf']")
    public WebElement logOut;

    public CinemaIndexPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void searchForWord(String word) throws InterruptedException {
        searchField.sendKeys(word + "\n");
    }

    public boolean listOfFilmsPresnts() {
        return filmsList.isDisplayed();
    }

    public int getFilmListLength() {
        String filmsNum = filmsNumber.getText();
        int filmsListLength = BaseSteps.converterStringToDigit(filmsNum);
        return filmsListLength;
    }

    public String getFilmTitle(WebDriver driver, int i) {
        String title = driver.findElement(By.xpath(String.format("//*[@id='root']/div[1]/div[1]/div[3]/div[2]/div[%s]/div[1]/div/a/span", i))).getText();
        return title;
    }

    public String getFilmDescription(WebDriver driver, int i) throws InterruptedException {
        driver.findElement(By.xpath(String.format("//*[@id='root']/div[1]/div[1]/div[3]/div[2]/div[%s]/div[1]/div/a", i))).click();
        TimeUnit.SECONDS.sleep(3);
        String description = driver.findElement(By.xpath("//*[contains(@class,'sc-TPgYF jipAap')]/span")).getText();
        return description;
    }

    public void enterEmail(String mail) {
        email.sendKeys(mail);
    }

    public void enterPassword(String psw) {

        password.sendKeys(psw + "\n");
    }

    public boolean levelPresrnts() {
        return level.isDisplayed();
    }

    public String messageText() {
        String text = messsage.getText();
        return text;
    }
}
