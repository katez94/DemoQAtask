package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.JSUtils;

import static tests.BaseTest.driver;

public class TextBoxPage {
    private final WebElement fullNameField = driver.findElement(By.id("userName"));
    private final WebElement emailField = driver.findElement(By.id("userEmail"));
    private final WebElement currentAddressField = driver.findElement(By.id("currentAddress"));
    private final WebElement permanentAddressField = driver.findElement(By.id("permanentAddress"));
    private final WebElement submitBtn = driver.findElement(By.id("submit"));
    private static final String outputNameLocator = "//*[@id='output']//*[contains(@id,'name')]";
    private static final String outputEmailLocator = "//*[@id='output']//*[contains(@id,'email')]";
    private static final String outputCurrentAddressLocator = "//*[@id='output']//*[contains(@id,'currentAddress')]";
    private static final String outputPermanentAddressLocator = "//*[@id='output']//*[contains(@id,'permanentAddress')]";

    public void inputFullName(String fullName) {
        fullNameField.sendKeys(fullName);
    }

    public void inputEmail(String email) {
        emailField.sendKeys(email);
    }

    public void inputCurrentAddress(String currentAddress) {
        currentAddressField.sendKeys(currentAddress);
    }

    public void inputPermanentAddress(String permanentAddress) {
        permanentAddressField.sendKeys(permanentAddress);
    }

    public void clickSubmitButton() {
        JSUtils.clickOnElement(submitBtn);
    }

    public String getOutputName() {
        final WebElement outputName = driver.findElement(By.xpath(outputNameLocator));
        return outputName.getText();
    }

    public String getOutputEmail() {
        final WebElement outputEmail = driver.findElement(By.xpath(outputEmailLocator));
        return outputEmail.getText();
    }

    public String getOutputCurrentAddress() {
        final WebElement outputCurrentAddress = driver.findElement(By.xpath(outputCurrentAddressLocator));
        return outputCurrentAddress.getText();
    }

    public String getOutputPermanentAddress() {
        final WebElement outputPermanentAddress = driver.findElement(By.xpath(outputPermanentAddressLocator));
        return outputPermanentAddress.getText();
    }
}
