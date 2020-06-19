package web_pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilites.StringToDigitsConverter;
import web_driver.Driver;

import java.util.concurrent.TimeUnit;

public class SilverscreenPage {
    private static final Logger LOGGER = LogManager.getLogger(SilverscreenPage.class);
    private static final String FILM_XPATH = "//*[@id='root']/div[1]/div[1]/div[3]/div[2]/div[%s]/div[1]/div/a";
    private static final String FILMTITLE_XPATH= "//*[@id='root']/div[1]/div[1]/div[3]/div[2]/div[%s]/div[1]/div/a/span";
    private static final String DESCRIPTION_XPATH = "//*[@class='sc-TPgYF jipAap']/span";
    @FindBy(xpath = "//*[@class='sc-hcmgZB bUJCje sc-iomxrj jGDOQB']")
    private WebElement searchIcon;
    @FindBy(xpath = "//*[@class='sc-gzVnrw kpyERI']")
    private WebElement searchField;
    @FindBy(xpath = "//*[@class='sc-dUZuEM loEZjI']")
    private WebElement filmsList;
    @FindBy(xpath = "//*[@class='sc-htoDjs jJISGf']")
    private WebElement filmsNumber;
    @FindBy(xpath = "//*[@class='sc-fyjhYU eVJmYW']")
    public WebElement login;
    @FindBy(xpath = "//*[@type='email']")
    private WebElement email;
    @FindBy(xpath = "//*[@type='password']")
    private WebElement password;
    @FindBy(xpath = "//*[@class='sc-fyjhYU eVJmYW']/span")
    private WebElement level;
    @FindBy(xpath = "//*[@class='sc-hqFvvW gGBuI']")
    private WebElement message;

    Actions actions;

    public SilverscreenPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    public void searchForWord(String word) throws InterruptedException {
        actions.moveToElement(searchIcon).build().perform();
        searchField.sendKeys(word + "\n");
        LOGGER.debug("The method completes search field with search word");
    }

    public boolean listOfFilmsPresnts() {
        return filmsList.isDisplayed();
    }

    public int getFilmListLength() {
        String filmsNum = filmsNumber.getText();
        int filmsListLength = StringToDigitsConverter.converterStringToDigit(filmsNum);
        LOGGER.debug("The method returns length of the films' list");
        return filmsListLength;
    }

    public String getFilmTitle(int i) {
        String title = Driver.getDriver().findElement(By.xpath(String.format(FILMTITLE_XPATH, i))).getText();
        LOGGER.debug("The method returns the film's title");
        return title;
    }

    public String getFilmDescription(int i) throws InterruptedException {
        Driver.getDriver().findElement(By.xpath(String.format(FILM_XPATH, i))).click();
        TimeUnit.SECONDS.sleep(3);
        String description = Driver.getDriver().findElement(By.xpath(DESCRIPTION_XPATH)).getText();
        LOGGER.debug("The method returns the film's description");
        return description;
    }

    public boolean findSearchWord(String searchWord, int i) throws InterruptedException {
        boolean result = false;
        if (getFilmTitle(i).contains(searchWord) == true) {
            result = getFilmTitle(i).contains(searchWord);
        } else {
            result = getFilmDescription(i).contains(searchWord);
        }
        LOGGER.debug("The method checks the existence of the search word in the film's title or description");
        return result;
    }

    public void enterEmail(String mail) {
        email.sendKeys(mail);
        LOGGER.debug("The method fills the email field");
    }

    public void enterPassword(String psw) {
        password.sendKeys(psw + "\n");
        LOGGER.debug("The method fills the password field");
    }

    public String levelText() {
        String levelText=level.getText();
        LOGGER.debug("The method returns user's level");
        return levelText;
    }

    public String messageText() {
        String text = message.getText();
        LOGGER.debug("The method return the message text");
        return text;
    }
}
