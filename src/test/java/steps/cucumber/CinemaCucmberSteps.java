package steps.cucumber;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import webDriver.Config;
import webDriver.Driver;
import webDriver.SilverscreenProperties;
import webPages.SilverscreenPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class CinemaCucmberSteps {
    SilverscreenPage silverscreenPage;
    static SilverscreenProperties silverscreenProperties = new SilverscreenProperties();
    static Actions actions;

    @Before
    public void preCondition() throws IOException {
        Driver.initDriver(Config.CHROME);
        WebDriver driver = Driver.getDriver();
        silverscreenPage = new SilverscreenPage(driver);
        actions = new Actions(driver);
    }

    @Given("I open an app")
    public void iOpenAnApp() {
        Driver.windowMaxSize();
        Driver.getURL(silverscreenProperties.getUrlSilverscreen());
    }

    @When("I search for <search word> word")
    public void iSearchForSearchWordWord() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        // actions.moveToElement(silverscreenPage.searchIcon).build().perform();
        silverscreenPage.searchForWord(silverscreenProperties.getSearchWord());
        TimeUnit.SECONDS.sleep(10);
    }

    @Then("I see the list of movie items")
    public void iSeeTheListOfMovieItems() {
        Assert.assertTrue(silverscreenPage.listOfFilmsPresnts());
    }

    @Then("each item name or description contains <search word>")
    public void eachItemNameOrDescriptionContainsSearchWord() throws InterruptedException {
        for (int i = 1; i <= silverscreenPage.getFilmListLength(); i++) {
            Assert.assertTrue(silverscreenPage.findSearchWord(silverscreenProperties.getSearchWord(), i));
        }
        Driver.goBack();
        TimeUnit.SECONDS.sleep(3);
    }

    @When("I login with <login> and <password>")
    public void iLoginWithLoginAndPassword() throws InterruptedException {
        String login = silverscreenProperties.getEmail();
        String password = silverscreenProperties.getPassword();
        TimeUnit.SECONDS.sleep(10);
        actions.moveToElement(silverscreenPage.login).build().perform();
        TimeUnit.SECONDS.sleep(3);
        silverscreenPage.enterEmail(login);
        silverscreenPage.enterPassword(password);
    }

    @Then("I can see Red Carpet Club <level> in upper right corner")
    public void iCanSeeRedCarpetClubLevelInUpperRightCorner() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        String level = "Новичок";
        Assert.assertTrue(silverscreenPage.levelText().contains(level));
    }

    @When("I left blank login field")
    public void iLeftBlankLoginField() throws InterruptedException {
        String password = silverscreenProperties.getPassword();
        actions.moveToElement(silverscreenPage.login).build().perform();
        TimeUnit.SECONDS.sleep(3);
        silverscreenPage.enterPassword(password);
    }

    @Then("I see Необходимо заполнить поле E-mail message")
    public void iSeeНеобходимоЗаполнитьПолеEMailMessage() {
        Assert.assertTrue(silverscreenPage.messageText().contains("Необходимо заполнить поле \"E-mail\""));
    }

    @When("I left blank password field")
    public void iLeftBlankPasswordField() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        String email = silverscreenProperties.getEmail();
        actions.moveToElement(silverscreenPage.login).build().perform();
        TimeUnit.SECONDS.sleep(3);
        silverscreenPage.enterEmail(email + "\n");
    }

    @Then("I see Необходимо заполнить поле Пароль message")
    public void iSeeНеобходимоЗаполнитьПолеПарольMessage() {
        Assert.assertTrue(silverscreenPage.messageText().contains("Необходимо заполнить поле \"Пароль\""));
    }

    @When("I login with wrong <login> and <password>")
    public void iLoginWithWrongLoginAndPassword() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        String email = silverscreenProperties.getWrongEmail();
        actions.moveToElement(silverscreenPage.login).build().perform();
        silverscreenPage.enterEmail(email);
        silverscreenPage.enterPassword(silverscreenProperties.getPassword());
    }

    @Then("I see <message> message")
    public void iSeeMessageMessage() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        Assert.assertTrue(silverscreenPage.messageText().contains("Пользователь не найден"));
    }

    @After
    public void postCondition() throws InterruptedException {
        Driver.clearCache();
    }
}