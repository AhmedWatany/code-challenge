package TajawalTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import BusinessHandlers.FlightDetailsPageBusinessHandler;
import BusinessHandlers.FlightListPagePageBusinessHandler;
import BusinessHandlers.HomePageBusinessHandler;

public class TajawalTestSeleniumTestNG extends Setup {

    HomePageBusinessHandler homePageBusinessHandler;

    FlightListPagePageBusinessHandler flightListPageBusinessHandler;

    FlightDetailsPageBusinessHandler flightDetailsPageBusinessHandler;

    @BeforeClass
    public void intialize() {
        homePageBusinessHandler = new HomePageBusinessHandler(driver);
        flightListPageBusinessHandler = new FlightListPagePageBusinessHandler(driver);
        flightDetailsPageBusinessHandler = new FlightDetailsPageBusinessHandler(driver);
    }

    @Test(priority = 1, enabled = true)
    public void HomePageTest() throws InterruptedException {
        homePageBusinessHandler.addingSearchParametersWithRondomData();
        flightListPageBusinessHandler.assertAndFilter();
        flightDetailsPageBusinessHandler.detailsScreenTest();
    }

    @Test(priority = 2, enabled = true)
    public void FlightListPageTest() throws Exception {
        homePageBusinessHandler.addingSearchParametersStaticData();
        flightListPageBusinessHandler.reOrdringAndAssertOnLowestPrice();
    }

}
