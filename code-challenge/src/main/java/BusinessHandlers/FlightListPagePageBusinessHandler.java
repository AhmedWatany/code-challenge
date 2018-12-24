package BusinessHandlers;

import java.io.File;

import org.openqa.selenium.WebDriver;

import TajawalPages.FlightListPage;

public class FlightListPagePageBusinessHandler {

    FlightListPage flightListPage;

    public FlightListPagePageBusinessHandler(WebDriver driver) {
        flightListPage = new FlightListPage(driver);
    }

    public void assertAndFilter() throws InterruptedException {

        flightListPage.assertOnSearchQuery();
        flightListPage.filterByEmiratesAirLine();
        flightListPage.selectRandomFlight();
    }

    public void reOrdringAndAssertOnLowestPrice() throws Exception {
        flightListPage.ascendingOrdering();
        flightListPage.assertOnLowestPrice();
        flightListPage.savePriceListIntoCSVFile();
        flightListPage.takeSnapShot(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources"
                + File.separator + "screenshots" + File.separator + "ScreenShot" + "-" + System.currentTimeMillis() + ".JPEG");
    }

}
