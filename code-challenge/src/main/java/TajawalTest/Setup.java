package TajawalTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class Setup {

    static WebDriver driver;

    protected static Logger log;

    public static JSONDataProvider jsonObject;

    static protected String URL;

    // @DataProvider(name = "data")
    // public static Object[][] getData() throws SQLException {
    //
    //// DataBaseConnector db = new DataBaseConnector();
    //// return db.getDataFromDataBase(jsonObject.getJsonValue("dataBaseName"), jsonObject.getJsonValue("userName"),
    // jsonObject.getJsonValue("password"));
    // }

    @Parameters({ "browser", "url", "driverName" })
    @BeforeSuite
    public void intiateDriver(String browser, String url, String driverName) throws FileNotFoundException, IOException {
        if (driver == null) {
            URL = url;
            String userDir = System.getProperty("user.dir");
            jsonObject = new JSONDataProvider(this.getClass().getSimpleName());
            String log4jConfigFile = userDir + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator
                    + "log4j.properties";
            ConfigurationSource source = new ConfigurationSource(new FileInputStream(log4jConfigFile));
            Configurator.initialize(null, source);
            log = Logger.getLogger(getClass());
            if (browser.equals("chrome")) {
                log.info("Starting Chrome Driver");
                String exePath = userDir + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "drivers"
                        + File.separator + driverName;
                System.setProperty("webdriver.chrome.driver", exePath);
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--kiosk");
                // chromeOptions.addArguments("--user-data-dir=" + chromeProfilePath);
                driver = new ChromeDriver(chromeOptions);
            } else if (browser.equals("fireFox")) {
                log.info("Starting FireFox Driver");
                String exePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "drivers" + File.separator + "geckodriver";
                System.setProperty("webdriver.gecko.driver", exePath);
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            } else {
                log.info("Driver not exist");
                return;
            }

            driver.get(url);
        }
    }

    @AfterClass
    public void driverQuit() {
        try {
            if (driver.equals(null) == false) {
                driver.quit();
            }
        } catch (Exception e) {
            log.info("Can not quit the driver: " + e);
        }
    }

}
