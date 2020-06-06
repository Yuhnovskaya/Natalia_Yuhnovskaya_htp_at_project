package steps.cucumber;


import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import webDriver.Config;
import webDriver.DrManager;
import webDriver.Prop;
import webPages.CinemaIndexPage;

import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class CinemaCucmberSteps {
    private static final Logger LOGGER= LogManager.getLogger(CinemaCucmberSteps.class);
    static WebDriver driver = DrManager.getDriver(Config.CHROME);
    static CinemaIndexPage cinemaIndexPage = new CinemaIndexPage(driver);
    static Properties prop = Prop.getProp();
    static Actions actions = new Actions(driver);
    static String searchWord = "Дэдпул";

    @Given("I open an app")
    public void iOpenAnApp() {
        driver.manage().window().maximize();
        driver.get("https://silverscreen.by/");
    }

    @When("I search for <search word> word")
    public void iSearchForSearchWordWord() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        actions.moveToElement(cinemaIndexPage.searchIcon).build().perform();
        cinemaIndexPage.searchForWord(searchWord);
        TimeUnit.SECONDS.sleep(5);
    }

    @Then("I see the list of movie items")
    public void iSeeTheListOfMovieItems() {
        Assert.assertTrue(cinemaIndexPage.listOfFilmsPresnts());
    }

    @Then("each item name or description contains <search word>")
    public void eachItemNameOrDescriptionContainsSearchWord() throws InterruptedException {
        for (int i = 1; i <= cinemaIndexPage.getFilmListLength(); i++) {
            if (cinemaIndexPage.getFilmTitle(driver, i).contains(searchWord) == true) {
                Assert.assertTrue(cinemaIndexPage.getFilmTitle(driver, i).contains(searchWord));
            } else {
                Assert.assertTrue(cinemaIndexPage.getFilmDescription(driver, i).contains(searchWord));
                driver.navigate().back();
                TimeUnit.SECONDS.sleep(3);
            }
        }
    }

@When("I login with <login> and <password>")
    public void iLoginWithLoginAndPassword() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        String email = "n.yuhnovskaya@yandex.ru";
        actions.moveToElement(cinemaIndexPage.login).build().perform();
        TimeUnit.SECONDS.sleep(3);
        cinemaIndexPage.enterEmail(email);
        cinemaIndexPage.enterPassword(prop.getProperty("BOOKING_PSW"));
    }

    @Then("I can see Red Carpet Club <level> in upper right corner")
    public void iCanSeeRedCarpetClubLevelInUpperRightCorner() {
        Assert.assertTrue(cinemaIndexPage.levelPresrnts());
    }

    @When("I left blank login field")
    public void iLeftBlankLoginField() throws InterruptedException {
        actions.moveToElement(cinemaIndexPage.login).build().perform();
        TimeUnit.SECONDS.sleep(3);
        cinemaIndexPage.enterPassword(prop.getProperty("BOOKING_PSW"));
    }

    @Then("I see Необходимо заполнить поле E-mail message")
    public void iSeeНеобходимоЗаполнитьПолеEMailMessage() {
        Assert.assertTrue(cinemaIndexPage.messageText().contains("Необходимо заполнить поле \"E-mail\""));
    }

    @When("I left blank password field")
    public void iLeftBlankPasswordField() throws InterruptedException {
        String email = "n.yuhnovskaya@yandex.ru";
        actions.moveToElement(cinemaIndexPage.login).build().perform();
        TimeUnit.SECONDS.sleep(3);
        cinemaIndexPage.enterEmail(email + "\n");
    }

    @Then("I see Необходимо заполнить поле Пароль message")
    public void iSeeНеобходимоЗаполнитьПолеПарольMessage() {
        Assert.assertTrue(cinemaIndexPage.messageText().contains("Необходимо заполнить поле \"Пароль\""));
    }

    @When("I login with wrong <login> and <password>")
    public void iLoginWithWrongLoginAndPassword() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        //  TrashMailSteps trashMailSteps=new TrashMailSteps();
        String email = "n.test@yandex.ru";
        actions.moveToElement(cinemaIndexPage.login).build().perform();
        cinemaIndexPage.enterEmail(email);
        cinemaIndexPage.enterPassword(prop.getProperty("BOOKING_PSW"));
    }

    @Then("I see <message> message")
    public void iSeeMessageMessage() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        Assert.assertTrue(cinemaIndexPage.messageText().contains("Пользователь не найден"));
    }
/*    @After
    public static void closeDriver() {
        driver.close();
    }*/
}