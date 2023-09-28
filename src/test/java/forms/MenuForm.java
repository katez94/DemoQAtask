package forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.JSUtils;

import static tests.BaseTest.driver;

public class MenuForm {
    private final WebElement elementsCategoryList = driver.findElement(By.xpath("//*[contains(@class,'group-header') and .//*[contains(text(),'Elements')]]/following-sibling::div"));
    private final WebElement elementsCategory = driver.findElement(By.xpath("//*[contains(@class,'group-header') and .//*[contains(text(),'Elements')]]"));
    private final WebElement textBoxItem = driver.findElement(By.xpath("//*[text()='Text Box']/parent::li"));
    private final WebElement buttonsItem = driver.findElement(By.xpath("//*[text()='Buttons']/parent::li"));
    private final WebElement alertsFrameWindowsCategory = driver.findElement(By.xpath("//*[contains(@class,'group-header') and .//*[contains(text(),'Alerts')]]"));
    private final WebElement alertsFrameWindowsCategoryList = driver.findElement(By.xpath("//*[contains(@class,'group-header') and .//*[contains(text(),'Alerts')]]/following-sibling::div"));
    private final WebElement browserWindowsItem = driver.findElement(By.xpath("//*[text()='Browser Windows']/parent::li"));
    private final WebElement alertsItem = driver.findElement(By.xpath("//*[text()='Alerts']/parent::li"));

    public void clickTextBoxItem() {
        if (!isCategoryListVisible(elementsCategoryList)) {
            elementsCategory.click();
        }
        textBoxItem.click();
    }

    public void clickButtonsItem() {
        if (!isCategoryListVisible(elementsCategoryList)) {
            elementsCategory.click();
        }
        JSUtils.clickOnElement(buttonsItem);
    }

    public void openAlertsFrameWindowsCategory() {
        JSUtils.scrollToElement(alertsFrameWindowsCategory);
        JSUtils.clickOnElement(alertsFrameWindowsCategory);
    }

    public void clickBrowserWindowsItem() {
        if (!isCategoryListVisible(alertsFrameWindowsCategoryList)) {
            JSUtils.clickOnElement(alertsFrameWindowsCategory);
        }
        JSUtils.clickOnElement(browserWindowsItem);
    }

    public void clickAlertsItem() {
        if (!isCategoryListVisible(alertsFrameWindowsCategoryList)) {
            JSUtils.clickOnElement(alertsFrameWindowsCategory);
        }
        JSUtils.clickOnElement(alertsItem);
    }

    private Boolean isCategoryListVisible(WebElement categoryList) {
        return categoryList.getAttribute("class").contains("show");
    }
}
