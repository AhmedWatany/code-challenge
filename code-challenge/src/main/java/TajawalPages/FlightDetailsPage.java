package TajawalPages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightDetailsPage extends BasePage {

    @FindBy(className = "steps-bar__step-text")
    private WebElement stepsBar;

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

    public FlightDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void assertOnCartPrice() {
        log.info("asserting on cart price");
        waitForVisabilty(stepsBar, 30);
        List<WebElement> arrowOfDetailsList = priceDetalisListSection.findElements(By.className("fare-summary__dropdown-arrow"));
        for (WebElement arrowDown : arrowOfDetailsList) {
            arrowDown.click();
        }
        List<Integer> priceListInInteger = new ArrayList<Integer>();
        for (WebElement priceDetails : priceDetailsList) {
            priceListInInteger.add(convertFromStringToInt(priceDetails.getText()));
        }
        String serviceFeeText = serviceFee.findElement(By.className("text-chambray")).getText();
        String vatText = vat.getText();
        String totalPriceText = totalPrice.findElement(By.className("pull-right")).getText();
        int calculatedTotalInInteger = calculate(priceListInInteger) + convertFromStringToInt(vatText) + convertFromStringToInt(serviceFeeText);
        int fitchedTotalPrice = convertFromStringToInt(totalPriceText);
        assertEquals(calculatedTotalInInteger, fitchedTotalPrice);
        log.info("asserting on cart price done successfully");
    }

    public void setTravelOneFirstName(String fName) {

        log.info("entering first name to the first passenger");
        setDataToElemnt(travelOneFirstName, fName);
        log.info("the first passenger first name entered successfully");

    }

    public void setTravelOneLastName(String lName) {
        log.info("entering last name to the first passenger");
        setDataToElemnt(travelOneLastName, lName);
        log.info("the first passenger last name entered successfully");

    }

    public void setTravelTwoFirstName(String fName) {
        log.info("entering first name to the second passenger");
        setDataToElemnt(travelTwoFirstName, fName);
        log.info("the second passenger first name entered successfully");

    }

    public void setTravelTwoLastName(String lName) {
        log.info("entering last name to the second passenger");
        setDataToElemnt(travelTwoLastName, lName);
        log.info("the second passenger last name entered successfully");

    }

    public void setContactFirstName(String fName) {
        log.info("entering first name of contact");
        setDataToElemnt(contactDetailsFirstName, fName);
        log.info("first name of contact entered successfully");

    }

    public void setContactLastName(String lName) {
        log.info("entering last name of contact");
        setDataToElemnt(contactDetailsLastName, lName);
        log.info("last name of contact successfully");

    }

    public void setContactEmail(String email) {
        log.info("entering the email of contact");
        setDataToElemnt(contactDetailsEmail, email);
        log.info("the email of contact entered successfully");

    }

    public void setContactPhone(String phoneNumber) {
        log.info("entering the phone number of contact");
        setDataToElemnt(contactDetailsPhone, phoneNumber);
        log.info("the phone number of contact entered successfully");

    }

    public void setTravelerOneTitle(String title) {
        log.info("entering title to the first passenger");
        selectFromDropDownMenu(travelOneTitle, title);
        log.info("the first passenger title entered successfully");

    }

    public void setTravelerTwoTitle(String title) {
        log.info("entering title to the second passenger");
        selectFromDropDownMenu(travelTwoTitle, title);
        log.info("the second passenger title entered successfully");
    }

}
