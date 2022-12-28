package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import static tests.LocalDriverManager.BrowserType.LOCAL;

public class BaseTest {

    protected WebDriver driver;


    @BeforeTest
    @Parameters({"browserType"})
    protected void setUp(String browserType) {
        //WebDriverManager.chromedriver().setup();
        LocalDriverManager localDriverManager = new LocalDriverManager();
        driver = localDriverManager.createInstance(browserType, LOCAL);

        // driver = WebDriverManager.chromedriver().create();  //new ChromeDriver();

        driver.manage().window().maximize();
    }

    @AfterTest
    protected void teardown() {
        driver.quit();
    }
}
