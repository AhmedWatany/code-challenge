package TajawalPages;

import java.io.File;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import TajawalTest.Setup;

public class BasePage extends Setup {

    WebDriver driver;

    static String[] originsArray = { "CAI Cairo, Egypt", "DOH Doha, Qatar", "LRR Lar, Iran - Lar Airport",
            "AMM Amman, Jordan - Queen Alia International Airport", "DQA Daqing, China" };

    static String[] destinationArray = { "DXB Dubai, United Arab Emirates", "DMM Dammam, Saudi Arabia", "BAH Bahrain, Bahrain - Bahrain International Airport",
            "BCN Barcelona, Spain and Canary Islands - Barcelona-El Prat Airport", "FRA Frankfurt, Germany" };

    protected static String originText = getRandom(originsArray);

    protected static String destinationText = getRandom(destinationArray);

    static String randomDate;

    static String returnDateText;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void waitForVisabilty(WebElement element, int time) {
        final WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public boolean waitForInVisabilty(WebElement element, int time) {
        try {
            final WebDriverWait wait = new WebDriverWait(driver, time);
            return wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            return false;

        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void setDataToElemnt(WebElement elemnt, String data) {
        elemnt.click();
        elemnt.clear();
        elemnt.sendKeys(data);
    }

    public void selectFromDropDownMenu(WebElement element, String value) {
        Select oSelect = new Select(element);
        oSelect.selectByValue(value);
    }

    public int getRandomBetweenRange(double min, double max) {
        int x = (int) ((Math.random() * ((max - min) + 1)) + min);
        return x;
    }

    public static String getRandom(String[] array) {
        int index = new Random().nextInt(array.length);
        return array[index];
    }

    public WebElement getRandom(List<WebElement> list) {
        int index = new Random().nextInt(list.size());
        return list.get(index);
    }

    public int convertFromStringToInt(String inputString) {
        String result = inputString;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) < 48 || inputString.charAt(i) > 57)
                result = result.replace(inputString.charAt(i) + "", "");
        }
        return Integer.valueOf(result);
    }

    public int calculate(List<Integer> inputList) {
        int sum = 0;
        for (Integer integer : inputList) {
            sum += integer;
        }
        return sum;
    }

    public void takeSnapShot(String fileWithPath) throws Exception {

        // Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot = ((TakesScreenshot) driver);

        // Call getScreenshotAs method to create image file

        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

        // Move image file to new destination

        File DestFile = new File(fileWithPath);

        // Copy file at destination

        Files.copy(SrcFile, DestFile);

    }
}
