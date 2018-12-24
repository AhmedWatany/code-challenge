package TajawalPages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "flights-search-origin-1")
    private WebElement origin;

    @FindBy(id = "flights-search-destination-1")
    private WebElement destination;

    @FindBy(id = "flights-search-departureDate-1")
    private WebElement startDate;

    @FindBy(className = "is-endrange")
    private WebElement returnDate;

    @FindBy(className = "is-today")
    private WebElement todayDate;

    @FindBy(id = "flights-search-cta")
    private WebElement searchButton;

    @FindBy(id = "flights-search-open-cabin-btn")
    private WebElement flightClassType;

    @FindBy(id = "flights-search-cabin-Economy-btn")
    private WebElement economy;

    @FindBy(id = "flights-search-open-pax-btn")
    private WebElement numberOfPassengers;

    @FindBy(className = "tj-icon--add-c")
    private WebElement addPassngerButton;

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
    private WebElement airLinesFilter;

    @FindBy(id = "flights-filters-airline-leg-0-check-exclude-0")
    private WebElement onlyButton;

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

    @FindBy(className = "pika-day")
    private List<WebElement> dateListLocator;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void setOrigin(String originText) {
        log.info("setting random origin");
        waitForVisabilty(origin, 30);
        setDataToElemnt(origin, originText);
        log.info("random origin entered successfully");
    }

    public void setDestination(String destinationText) {
        log.info("setting random destination");
        setDataToElemnt(destination, destinationText);
        log.info("random destination entered successfully");

    }

    public void setFlightType() {
        log.info("setting economy class type");
        flightClassType.click();
        economy.click();
        log.info("economy class type entered successfully");
    }

    public void addOnePassenger() {
        log.info("adding an adult passenger");
        numberOfPassengers.click();
        addPassngerButton.click();
        log.info("an adult passenger added successfully");
    }

    public void clickSearchButton() {
        log.info("clicking on search button");
        searchButton.click();
        log.info("search button clicked successfully");
    }

    public void setRondomDate() {
        log.info("setting random date");
        startDate.click();
        String todayDateText = todayDate.getText();
        int rondomStartDate = getRandomBetweenRange(Integer.valueOf(todayDateText), dateListLocator.size() - 1);
        randomDate = dateListLocator.get(rondomStartDate).getText();
        dateListLocator.get(rondomStartDate).click();
        returnDateText = returnDate.findElement(By.className("pika-day")).getText();
        log.info("random date entered successfully");

    }

    public void goToHomePage() {
        log.info("going to home page");
        driver.get(URL);
        log.info("home page loaded successfully");
    }

}
