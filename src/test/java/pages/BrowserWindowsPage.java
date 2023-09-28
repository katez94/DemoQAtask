package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.JSUtils;

import static tests.BaseTest.driver;

public class BrowserWindowsPage {
    private static final WebElement NEW_TAB_BUTTON = driver.findElement(By.cssSelector("#tabButton"));
    private static final WebElement NEW_WINDOW_BUTTON = driver.findElement(By.cssSelector("#windowButton"));

    public void clickNewTabButton() {
        JSUtils.clickOnElement(NEW_TAB_BUTTON);
    }

    public void clickNewWindowButton() {
        JSUtils.clickOnElement(NEW_WINDOW_BUTTON);
    }
}
