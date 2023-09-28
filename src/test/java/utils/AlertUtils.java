package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static tests.BaseTest.driver;

public class AlertUtils {
    private static final WebDriverWait WAIT = new WebDriverWait(driver, Duration.ofSeconds(7));
    private static Alert alert;

    public static void switchToAlert() {
        alert = driver.switchTo().alert();
    }

    public static void waitForAlertIsPresent() {
        WAIT.until(ExpectedConditions.alertIsPresent());
    }

    public static String getTextFromAlert() {
        return alert.getText();
    }

    public static void acceptAlert() {
        switchToAlert();
        alert.accept();
    }

    public static void inputTextToAlert(String text) {
        alert.sendKeys(text);
    }
}
