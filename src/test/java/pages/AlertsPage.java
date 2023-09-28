package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static tests.BaseTest.driver;

public class AlertsPage {
    private final WebElement alertButton = driver.findElement(By.cssSelector("#alertButton"));
    private final WebElement alertInFiveSecondsButton = driver.findElement(By.cssSelector("#timerAlertButton"));
    private final WebElement confirmBoxButton = driver.findElement(By.cssSelector("#confirmButton"));
    private final WebElement promptBoxButton = driver.findElement(By.cssSelector("#promtButton"));
    private final String confirmBoxButtonResultLocator = "#confirmResult";
    private final String promptBoxButtonResultLocator = "#promptResult";

    public void clickAlertButton() {
        alertButton.click();
    }

    public void clickAlertInFiveSecondsButton() {
        alertInFiveSecondsButton.click();
    }

    public void clickConfirmBoxButton() {
        confirmBoxButton.click();
    }

    public void clickPromptBoxButton() {
        promptBoxButton.click();
    }

    public String getTextFromConfirmBoxButtonResult() {
        final WebElement confirmBoxButtonResult = driver.findElement(By.cssSelector(confirmBoxButtonResultLocator));
        return confirmBoxButtonResult.getText();
    }

    public String getTextFromPromptBoxButtonResult() {
        final WebElement promptBoxButtonResult = driver.findElement(By.cssSelector(promptBoxButtonResultLocator));
        return promptBoxButtonResult.getText();
    }
}
