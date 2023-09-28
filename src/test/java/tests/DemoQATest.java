package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import steps.Steps;

public class DemoQATest extends BaseTest {
    private final static String FULL_NAME = RandomStringUtils.randomAlphabetic(10);
    private final static String EMAIL = "testmail@gmail.com";
    private final static String CURRENT_ADDRESS = "Moscow";
    private final static String PERMANENT_ADDRESS = "Saint-Petersburg";
    private final static String EXPECTED_CLICK_BUTTON_MESSAGE = "You have done a dynamic click";
    private final static String EXPECTED_RIGHT_CLICK_BUTTON_MESSAGE = "You have done a right click";
    private final static String EXPECTED_DOUBLE_CLICK_BUTTON_MESSAGE = "You have done a double click";
    private final static String EXPECTED_CONFIRM_BUTTON_MESSAGE = "You selected Ok";
    private final static String TEXT_TO_SEND_TO_PROMPT_BOX = "Test name";

    @Test(description = "DemoQaTest")
    public void test() {
        Steps.openElementsCategory();
        Steps.clickTextBoxItem();
        Steps.fillInTexBoxForm(FULL_NAME, EMAIL, CURRENT_ADDRESS, PERMANENT_ADDRESS);
        Steps.clickButtonsItem();
        Steps.clickOnClickMeButton(EXPECTED_CLICK_BUTTON_MESSAGE);
        Steps.clickOnRightClickMeButton(EXPECTED_RIGHT_CLICK_BUTTON_MESSAGE);
        Steps.clickOnDoubleClickMeButton(EXPECTED_DOUBLE_CLICK_BUTTON_MESSAGE);
        Steps.openAlertsFrameWindowsCategory();
        Steps.clickBrowserWindowsItem();
        Steps.clickNewTabButton();
        Steps.closeNewTab();
        Steps.clickNewWindowButton();
        Steps.closeNewWindow();
        Steps.clickAlertsItem();
        Steps.getAlertAndAcceptIt();
        Steps.getAlertInFiveSecondsAndAcceptIt();
        Steps.getConfirmBoxAndAcceptIt(EXPECTED_CONFIRM_BUTTON_MESSAGE);
        Steps.getPromptBoxAndSendText(TEXT_TO_SEND_TO_PROMPT_BOX);
    }
}
