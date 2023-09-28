package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static tests.BaseTest.driver;
import static tests.BaseTest.getActions;

public class ButtonsPage {
    private final WebElement clickButton = driver.findElement(By.xpath("//*[contains(@class,'btn') and starts-with(text(),'Click Me')]"));
    private final WebElement rightClickButton = driver.findElement(By.xpath("//*[contains(text(),'Right Click Me')]"));
    private final WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
    private static final String clickButtonMessageLocator = "dynamicClickMessage";
    private static final String rightClickButtonMessageLocator = "rightClickMessage";
    private static final String doubleClickButtonMessageLocator = "doubleClickMessage";

    public void clickClickButton() {
        clickButton.click();
    }

    public void clickRightClickButton() {
        getActions().contextClick(rightClickButton).perform();
    }

    public void clickDoubleClickButton() {
        getActions().doubleClick(doubleClickButton).perform();
    }

    public String getClickButtonMessage() {
        getActions().scrollToElement(doubleClickButton);
        final WebElement clickButtonMessage = driver.findElement(By.id(clickButtonMessageLocator));
        return clickButtonMessage.getText();
    }

    public String getRightClickButtonMessage() {
        final WebElement rightClickButtonMessage = driver.findElement(By.id(rightClickButtonMessageLocator));
        return rightClickButtonMessage.getText();
    }

    public String getDoubleClickButtonMessage() {
        final WebElement doubleClickButtonMessage = driver.findElement(By.id(doubleClickButtonMessageLocator));
        return doubleClickButtonMessage.getText();
    }

}
