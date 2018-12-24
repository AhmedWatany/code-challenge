package TajawalPages;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import TajawalTest.CSV;

public class FlightListPage extends BasePage {

    @FindBy(className = "flights-progress-bar__text")
    private WebElement progressBarText;

    @FindBy(className = "img-reverse")
    private List<WebElement> descendingImage;

    @FindBy(className = "search-result-card__price")
    private List<WebElement> listOfAllPrices;

    @FindBy(className = "desktop-summary__label--highlighted")
    private List<WebElement> listOfSearchSummaryPlaces;

    @FindBy(className = "desktop-summary__value--highlighted")
    private List<WebElement> listOfSearchSummaryValues;

    @FindBy(className = "filter-flights-airlines")
    private List<WebElement> airLinesFilter;

    @FindBy(id = "flights-filters-airline-leg-0-check-exclude-0")
    private WebElement onlyButton;

    @FindBy(id = "flights-filters-airline-leg-1-check-exclude-0")
    private WebElement returnOnlyButton;

    @FindBy(className = "search-result-card__cta")
    private List<WebElement> listOfAllFlights;

    @FindBy(className = "steps-bar__step-text")
    private WebElement stepsBar;

    @FindBy(className = "search-result-card__price")
    private WebElement flightPrice;

    @FindBy(className = "tj-rate__price")
    private List<WebElement> priceDetailsList;

    @FindBy(className = "www-fare-price")
    private WebElement priceDetalisListSection;

    @FindBy(className = "total-payment__taxes")
    private WebElement serviceFee;

    @FindBy(className = "tourfee_price")
    private WebElement vat;

    @FindBy(className = "total-payment__title")
    private WebElement totalPrice;

    @FindBy(id = "flights-summary-travelers-form-first-name-0")
    private WebElement travelOneFirstName;

    @FindBy(id = "flights-summary-travelers-form-last-name-0")
    private WebElement travelOneLastName;

    @FindBy(id = "flights-summary-travelers-form-title-0")
    private WebElement travelOneTitle;

    @FindBy(id = "flights-summary-travelers-form-first-name-1")
    private WebElement travelTwoFirstName;

    @FindBy(id = "flights-summary-travelers-form-last-name-1")
    private WebElement travelTwoLastName;

    @FindBy(id = "flights-summary-travelers-form-title-1")
    private WebElement travelTwoTitle;

    @FindBy(id = "flights-summary-travelers-form-contact-fname")
    private WebElement contactDetailsFirstName;

    @FindBy(id = "flights-summary-travelers-form-contact-lname")
    private WebElement contactDetailsLastName;

    @FindBy(id = "flights-summary-travelers-form-contact-email")
    private WebElement contactDetailsEmail;

    @FindBy(id = "flights-summary-travelers-form-contact-phone")
    private WebElement contactDetailsPhone;

    public FlightListPage(WebDriver driver) {
        super(driver);
    }

    public void assertOnSearchQuery() {
        log.info("asserting on search query");
        waitForInVisabilty(progressBarText, 60);
        // check if the origin match the result module
        boolean isOriginMatch = originText.contains(listOfSearchSummaryPlaces.get(0).getText());
        assertEquals(isOriginMatch, true);
        // check if the destination match the result module
        boolean isDestinationMatch = destinationText.contains(listOfSearchSummaryPlaces.get(1).getText());
        assertEquals(isDestinationMatch, true);
        // check if the start date match the result module
        boolean isStartDateMatch = listOfSearchSummaryValues.get(0).getText().contains(randomDate);
        assertEquals(isStartDateMatch, true);
        // check if the end date match the result module
        boolean isEndDateMatch = listOfSearchSummaryValues.get(1).getText().contains(returnDateText);
        assertEquals(isEndDateMatch, true);
        // check if the number of passengers match the result module
        boolean isnumberOfPassengersMatch = listOfSearchSummaryValues.get(2).getText().equals("2");
        assertEquals(isnumberOfPassengersMatch, true);
        // check if class match the result module
        boolean isFlightClassTypeMatch = listOfSearchSummaryValues.get(3).getText().equals("Economy");
        assertEquals(isFlightClassTypeMatch, true);
        log.info("asserting on search query done successfully");
    }

    public void filterByEmiratesAirLine() {
        
        log.info("filtering by Emirates carrier air line");

        boolean IsEmiratesAirLineExist = false;
        Actions action = new Actions(driver);
        List<WebElement> airLinesList = airLinesFilter.get(0).findElements(By.className("font-base"));
        for (WebElement airLine : airLinesList) {
            if (airLine.getText().equals("EK: Emirates")) {
                IsEmiratesAirLineExist = true;
                action.moveToElement(airLine).build().perform();
                waitForVisabilty(onlyButton, 15);
                onlyButton.click();
                log.info("filter by first filter in going carrier air line done successfully");
                break;
            }
        }
        // if EK: Emirates not exist, it will click on first airLine Filter
        if (IsEmiratesAirLineExist == false) {
            action.moveToElement(airLinesList.get(0)).build().perform();
            waitForVisabilty(onlyButton, 15);
            onlyButton.click();
            log.info("filter by Emirates in going carrier air line done successfully");

        }

        // repeat on return filter
        IsEmiratesAirLineExist = false;
        List<WebElement> airLinesReturnList = airLinesFilter.get(1).findElements(By.className("font-base"));
        for (WebElement airLine : airLinesReturnList) {
            if (airLine.getText().equals("EK: Emirates")) {
                IsEmiratesAirLineExist = true;
                action.moveToElement(airLine).build().perform();
                waitForVisabilty(returnOnlyButton, 15);
                returnOnlyButton.click();
                log.info("filter by Emirates in return carrier air line done successfully");
                break;
            }
        }
        // if EK: Emirates not exist, it will click on first airLine Filter
        if (IsEmiratesAirLineExist == false) {
            action.moveToElement(airLinesReturnList.get(0)).build().perform();
            waitForVisabilty(returnOnlyButton, 15);
            returnOnlyButton.click();
            log.info("filter by first filter in return carrier air line done successfully");

        }

    }

    public void selectRandomFlight() {
        log.info("selecting random flight");
        WebElement randomFlight = getRandom(listOfAllFlights);
        WebElement flightButton = randomFlight.findElement(By.className("btn-cta"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
        waitForVisabilty(flightButton, 10);
        flightButton.click();
        log.info("selecting random flight done successfully");

    }

    public void ascendingOrdering() {
        log.info("reordring flight list to be ascending");
        waitForInVisabilty(progressBarText, 60);
        // check if the img-reverse exists and if true will click on it to reverse the order to be (Ascending)
        if (descendingImage.size() > 0)
            descendingImage.get(0).click();
        log.info("reordring flight list to be ascending done successfully");

    }

    public void assertOnLowestPrice() {
        log.info("asserting on lowest price in flight list");
        String lowestPrice = listOfAllPrices.get(0).getText();
        boolean isLowest = true;
        for (int i = 1; i < listOfAllPrices.size(); i++) {
            int isGreater = lowestPrice.compareTo(listOfAllPrices.get(i).getText());
            isLowest = isGreater > 0;
            if (isLowest)
                Assert.fail("The first price is not the lowest price");
            else
                isLowest = true;
        }
        assertEquals(isLowest, true);
        log.info("asserting on lowest price in flight list done successfully");
    }

    public void savePriceListIntoCSVFile() throws FileNotFoundException {
        log.info("saving price list into CSV file");
        CSV csv = new CSV();
        csv.writeIntoCSVFile(listOfAllPrices);
        log.info("price list saved successfully");
    }

}
