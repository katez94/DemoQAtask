package utils;

import java.util.Iterator;
import java.util.Set;

import static tests.BaseTest.driver;

public class BrowserUtils {
    private static final String MAIN_WINDOW = driver.getWindowHandle();
    private static Set<String> windows;

    public static void switchToNewTab() {
        windows = driver.getWindowHandles();
        Iterator<String> i = windows.iterator();
        while (i.hasNext()) {
            String anotherTab = i.next();
            if (!MAIN_WINDOW.equals(anotherTab)) {
                driver.switchTo().window(anotherTab);
            }
        }
    }

    public static void switchToMainWindow() {
        Iterator<String> i = windows.iterator();
        while (i.hasNext()) {
            String anotherWindow = i.next();
            if (MAIN_WINDOW.equals(anotherWindow)) {
                driver.switchTo().window(MAIN_WINDOW);
            }
        }
    }

    public static void closeNewTab() {
        switchToNewTab();
        driver.close();
        switchToMainWindow();
    }
}
