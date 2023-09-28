package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.zaikina.framework.utils.webdriver.factory.WebDriverFactoryImpl;

public class BaseTest {
    public static WebDriver driver;

    @BeforeTest
    public void init() {
        driver = new WebDriverFactoryImpl().getDriver();
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

    public static Actions getActions() {
        return new Actions(driver);
    }
}
