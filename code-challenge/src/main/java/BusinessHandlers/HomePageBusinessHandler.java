package BusinessHandlers;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;

import TajawalPages.BasePage;
import TajawalPages.HomePage;

public class HomePageBusinessHandler extends BasePage {

    HomePage homePage;

    public HomePageBusinessHandler(WebDriver driver) {
        super(driver);
        homePage = new HomePage(driver);
    }

    public void addingSearchParametersWithRondomData() throws InterruptedException {

        homePage.setOrigin(originText);
        homePage.setDestination(destinationText);
        homePage.setRondomDate();
        homePage.setFlightType();
        homePage.addOnePassenger();
        homePage.clickSearchButton();

    }

    public void addingSearchParametersStaticData() throws InterruptedException, FileNotFoundException {

        log.info("going to home page");

        homePage.goToHomePage();

        log.info("home page loaded successfully");
        log.info("setting CAI Cairo, Egypt as an origin");

        homePage.setOrigin("CAI Cairo, Egypt");

        log.info("origin entered successfully");
        log.info("DXB Dubai, United Arab Emirates, as an destination");

        homePage.setDestination("DXB Dubai, United Arab Emirates");

        log.info("destination entered successfully");
        log.info("clicking on search button");

        homePage.clickSearchButton();

        log.info("search button clicked successfully");

    }

}
