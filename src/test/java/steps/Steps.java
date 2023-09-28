package steps;

import forms.MenuForm;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pages.*;
import tests.DemoQATest;
import utils.AlertUtils;
import utils.BrowserUtils;

public class Steps {
    private static final Logger log = LoggerFactory.getLogger(DemoQATest.class);

    @Step
    public static void openElementsCategory() {
        log.info("Click on «Elements» on main page");
        MainPage mainPage = new MainPage();
        mainPage.clickElementsCard();
    }

    @Step
    public static void clickTextBoxItem() {
        log.info("Click Text Box item");
        MenuForm menu = new MenuForm();
        menu.clickTextBoxItem();
    }

    @Step
    public static void fillInTexBoxForm(String fullName, String email, String currentAddress, String permanentAddress) {
        log.info("Fill in Text box form: Full Name, Email, Current Address, Permanent Address");
        TextBoxPage textBoxPage = new TextBoxPage();
        textBoxPage.inputFullName(fullName);
        textBoxPage.inputEmail(email);
        textBoxPage.inputCurrentAddress(currentAddress);
        textBoxPage.inputPermanentAddress(permanentAddress);
        log.info("Submit, the data was saved correctly");
        textBoxPage.clickSubmitButton();
        final String outputName = textBoxPage.getOutputName();
        final String outputEmail = textBoxPage.getOutputEmail();
        final String outputCurrentAddress = textBoxPage.getOutputCurrentAddress();
        final String outputPermanentAddress = textBoxPage.getOutputPermanentAddress();
        Assert.assertTrue(outputName.contains(fullName));
        Assert.assertTrue(outputEmail.contains(email));
        Assert.assertTrue(outputCurrentAddress.contains(currentAddress));
        Assert.assertTrue(outputPermanentAddress.contains(permanentAddress));
    }

    @Step
    public static void clickButtonsItem() {
        log.info("Click Buttons item");
        MenuForm menu = new MenuForm();
        menu.clickButtonsItem();
    }

    @Step
    public static void clickOnClickMeButton(String expectedText) {
        log.info("Click on Click Me button, «You have done a dynamic click» text appeared");
        ButtonsPage buttonsPage = new ButtonsPage();
        buttonsPage.clickClickButton();
        Assert.assertEquals(buttonsPage.getClickButtonMessage(), expectedText);
    }

    @Step
    public static void clickOnRightClickMeButton(String expectedText) {
        log.info("Click on Right Click Me button, «You have done a right click» text appeared");
        ButtonsPage buttonsPage = new ButtonsPage();
        buttonsPage.clickRightClickButton();
        Assert.assertEquals(buttonsPage.getRightClickButtonMessage(), expectedText);
    }

    @Step
    public static void clickOnDoubleClickMeButton(String expectedText) {
        log.info("Click on Double Click Me button, «You have done a double click» text appeared");
        ButtonsPage buttonsPage = new ButtonsPage();
        buttonsPage.clickDoubleClickButton();
        Assert.assertEquals(buttonsPage.getDoubleClickButtonMessage(), expectedText);
    }

    @Step
    public static void openAlertsFrameWindowsCategory() {
        log.info("Open Alerts, Frame & Windows category");
        MenuForm menu = new MenuForm();
        menu.openAlertsFrameWindowsCategory();
    }

    @Step
    public static void clickBrowserWindowsItem() {
        log.info("Click Browser Windows item");
        MenuForm menu = new MenuForm();
        menu.clickBrowserWindowsItem();
    }

    @Step
    public static void clickNewTabButton() {
        log.info("Click New Tab button");
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();
        browserWindowsPage.clickNewTabButton();
    }

    @Step
    public static void closeNewTab() {
        log.info("Close New Tab");
        BrowserUtils.closeNewTab();
    }

    @Step
    public static void clickNewWindowButton() {
        log.info("Click New Tab button");
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();
        browserWindowsPage.clickNewWindowButton();
    }

    @Step
    public static void closeNewWindow() {
        log.info("Close New Tab");
        BrowserUtils.closeNewTab();
    }

    @Step
    public static void clickAlertsItem() {
        log.info("Click Alerts item");
        MenuForm menu = new MenuForm();
        menu.clickAlertsItem();
    }

    @Step
    public static void getAlertAndAcceptIt() {
        log.info("Click «Click me» next to 'Click Button to see alert'");
        AlertsPage alertsPage = new AlertsPage();
        alertsPage.clickAlertButton();
        log.info("Accept alert");
        AlertUtils.acceptAlert();
    }

    @Step
    public static void getAlertInFiveSecondsAndAcceptIt() {
        log.info("Click «Click me» next to 'On button click, alert will appear after 5 seconds'");
        AlertsPage alertsPage = new AlertsPage();
        alertsPage.clickAlertInFiveSecondsButton();
        AlertUtils.waitForAlertIsPresent();
        log.info("Accept alert");
        AlertUtils.acceptAlert();
    }

    @Step
    public static void getConfirmBoxAndAcceptIt(String expectedText) {
        log.info("Click «Click me» next to 'On button click, confirm box will appear'");
        AlertsPage alertsPage = new AlertsPage();
        alertsPage.clickConfirmBoxButton();
        AlertUtils.acceptAlert();
        log.info("Assert result message after clicking Confirm Button");
        Assert.assertEquals(alertsPage.getTextFromConfirmBoxButtonResult(), expectedText);
    }

    @Step
    public static void getPromptBoxAndSendText(String expectedText) {
        log.info("Click «Click me» next to 'On button click, prompt box will appear'");
        AlertsPage alertsPage = new AlertsPage();
        alertsPage.clickPromptBoxButton();
        log.info("Input text to Prompt Box");
        AlertUtils.inputTextToAlert(expectedText);
        AlertUtils.acceptAlert();
        log.info("Assert result message after sending text to Prompt Box");
        Assert.assertTrue(alertsPage.getTextFromPromptBoxButtonResult().contains(expectedText));
    }
}
