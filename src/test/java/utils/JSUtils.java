package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static tests.BaseTest.driver;

public class JSUtils {
    public static JavascriptExecutor js = (JavascriptExecutor) driver;

    public static final String CLICK_ON_ELEMENT = "arguments[0].click();";
    public static final String SCROLL_TO_ELEMENT = "arguments[0].scrollIntoView(true);";

    public static void clickOnElement(WebElement webElement) {
        js.executeScript(JSUtils.CLICK_ON_ELEMENT, webElement);
    }

    public static void scrollToElement(WebElement webElement) {
        js.executeScript(JSUtils.SCROLL_TO_ELEMENT, webElement);
    }
}
