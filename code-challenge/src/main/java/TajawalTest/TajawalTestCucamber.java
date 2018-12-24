package TajawalTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import BusinessHandlers.FlightDetailsPageBusinessHandler;
import BusinessHandlers.FlightListPagePageBusinessHandler;
import BusinessHandlers.HomePageBusinessHandler;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class TajawalTestCucamber extends Setup {

    HomePageBusinessHandler homePageBusinessHandler;

    FlightListPagePageBusinessHandler flightListPageBusinessHandler;

    FlightDetailsPageBusinessHandler flightDetailsPageBusinessHandler;

    @Given("^user is on homepage (.*)$")
    public void OpenBrowser(String url) throws InterruptedException, FileNotFoundException, IOException {
        intiateDriver("chrome", url, "chromedriver");
    }

    @When("^user search with random parameters generated and click on search button$")
    public void HomePageTest() throws InterruptedException {
        homePageBusinessHandler = new HomePageBusinessHandler(driver);
        homePageBusinessHandler.addingSearchParametersWithRondomData();
    }

    @When("^user get to flight page and filter with 'Emirates'$")
    public void FlightListPageTest() throws InterruptedException {
        flightListPageBusinessHandler = new FlightListPagePageBusinessHandler(driver);
        flightListPageBusinessHandler.assertAndFilter();
    }

    @And("^user clicks flight details page$")
    public void FlightDetailsTest() throws InterruptedException {
        flightDetailsPageBusinessHandler = new FlightDetailsPageBusinessHandler(driver);
        flightDetailsPageBusinessHandler.detailsScreenTest();
    }
}
