package BusinessHandlers;

import org.openqa.selenium.WebDriver;

import TajawalPages.FlightDetailsPage;
import TajawalTest.Setup;

public class FlightDetailsPageBusinessHandler {

    FlightDetailsPage flightDetailsPage;

    public FlightDetailsPageBusinessHandler(WebDriver driver) {
        flightDetailsPage = new FlightDetailsPage(driver);

    }

    public void detailsScreenTest() throws InterruptedException {
        // details screen
        flightDetailsPage.assertOnCartPrice();
        flightDetailsPage.setTravelerOneTitle(Setup.jsonObject.getJsonValue("passengerOneTitle"));
        flightDetailsPage.setTravelOneFirstName(Setup.jsonObject.getJsonValue("passengerOneFirstName"));
        flightDetailsPage.setTravelOneLastName(Setup.jsonObject.getJsonValue("passengerOneLastName"));
        flightDetailsPage.setTravelerTwoTitle(Setup.jsonObject.getJsonValue("passengerTwoTitle"));
        flightDetailsPage.setTravelTwoFirstName(Setup.jsonObject.getJsonValue("passengerTwoFirstName"));
        flightDetailsPage.setTravelTwoLastName(Setup.jsonObject.getJsonValue("passengerTwoLastName"));
        flightDetailsPage.setContactFirstName(Setup.jsonObject.getJsonValue("contactFirstName"));
        flightDetailsPage.setContactLastName(Setup.jsonObject.getJsonValue("contactLastName"));
        flightDetailsPage.setContactEmail(Setup.jsonObject.getJsonValue("contactEmail"));
        flightDetailsPage.setContactPhone(Setup.jsonObject.getJsonValue("contactPhone"));
    }

}
