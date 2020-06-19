package steps.cucumber_steps.booking;

import cucumber.api.java.en.Then;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import web_driver.Config;
import web_driver.Driver;
import web_pages.*;

public class HeaderElementsCucumberSteps {
    WebDriver driver= Driver.initDriver(Config.CHROME);
    BookingHeader bookingHeader = new BookingHeader(driver);
    private static final Logger LOGGER = LogManager.getLogger(HeaderElementsCucumberSteps.class);
    @Then("I verify that header element account is present")
    public void iVerifyThatHeaderAccountIsPresent() {
        Assert.assertTrue(bookingHeader.accountPresents(driver));
    }

    @Then("I verify that header element airportTaxi is present")
    public void iVerifyThatHeaderAirportTaxiIsPresent() {
        Assert.assertTrue(bookingHeader.airportTaxiPresents(driver));
    }

    @Then("I verify that header element attractions is present")
    public void iVerifyThatHeaderAttractionsIsPresent() {
        Assert.assertTrue(bookingHeader.attractionsPresents(driver));
    }

    @Then("I verify that header element carRents is present")
    public void iVerifyThatHeaderCarRentsIsPresent() {
        Assert.assertTrue(bookingHeader.carRentsPresents(driver));
    }

    @Then("I verify that header element country is present")
    public void iVerifyThatHeaderCountryIsPresent() {
        Assert.assertTrue(bookingHeader.countryPresents(driver));
    }

    @Then("I verify that header element flights is present")
    public void iVerifyThatHeaderFlightsIsPresent() {
        Assert.assertTrue(bookingHeader.flightsPresents(driver));
    }

    @Then("I verify that header element help is present")
    public void iVerifyThatHeaderHelpIsPresent() {
        Assert.assertTrue(bookingHeader.helpPresents(driver));
    }

    @Then("I verify that header element language is present")
    public void iVerifyThatHeaderLanguageIsPresent() {
        Assert.assertTrue(bookingHeader.languagePresents(driver));
    }

    @Then("I verify that header element logo is present")
    public void iVerifyThatHeaderLogoIsPresent() {
        Assert.assertTrue(bookingHeader.logoPresents(driver));
    }

    @Then("I verify that header element property is present")
    public void iVerifyThatHeaderPropertyIsPresent() {
        Assert.assertTrue(bookingHeader.propertyPresents(driver));
    }

    @Then("I verify that header element stay is present")
    public void iVerifyThatHeaderStayIsPresent() {
        Assert.assertTrue(bookingHeader.stayPresents(driver));
    }
}

