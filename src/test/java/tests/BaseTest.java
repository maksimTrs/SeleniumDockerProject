package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;

import static tests.LocalDriverManager.BrowserType.LOCAL;
import static tests.LocalDriverManager.BrowserType.SELENIUM_GRID;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    // @Parameters({"browserType"})
    protected void setUp() throws MalformedURLException {
        //WebDriverManager.chromedriver().setup();


        String browserType = "CHROME";
        String host = "localhost"; // hub - for GRID

        LocalDriverManager localDriverManager = new LocalDriverManager();

        if (System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }

        if (System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            browserType = "FIREFOX";
        }
        driver = localDriverManager.createInstance(browserType, SELENIUM_GRID, host);
        System.out.println("+++++ AT Test was started for browser = " + browserType + " +++++");


       // driver = localDriverManager.createInstance(System.getProperty("BROWSER"), LOCAL, System.getProperty("HOST"));

        // driver = WebDriverManager.chromedriver().create();  //new ChromeDriver();

        driver.manage().window().maximize();
    }


   /* @BeforeTest
    public void setupDriver(ITestContext ctx) throws MalformedURLException {
        // BROWSER => chrome / firefox
        // HUB_HOST => localhost / 10.0.1.3 / hostname

        String host = "localhost";
        MutableCapabilities dc;

        if(System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc = new FirefoxOptions();
        }else{
            dc = new ChromeOptions();
        }

        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }

        String testName = ctx.getCurrentXmlTest().getName();

        String completeUrl = "http://" + host + ":4444/wd/hub";
        dc.setCapability("name", testName);
        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
    }*/


    @AfterTest
    protected void teardown() {
        driver.quit();
    }
}
