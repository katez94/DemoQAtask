package org.zaikina.framework.utils.webdriver.provider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.zaikina.framework.utils.webdriver.WebDriverConfigManager;

public class ChromeWebDriverProvider implements WebDriverProvider {
    private static ChromeWebDriverProvider chromeWebDriverProvider;
    private final WebDriver driver;

    private ChromeWebDriverProvider() {
        ChromeOptions options = new ChromeOptions();
        if (WebDriverConfigManager.getInstance().getMaximizedWindow()) {
            options.addArguments("---start-maximized");
        }
        driver = new ChromeDriver(options);
        driver.get(WebDriverConfigManager.getInstance().getUrl());
    }

    public static ChromeWebDriverProvider getInstance() {
        if (chromeWebDriverProvider == null) {
            chromeWebDriverProvider = new ChromeWebDriverProvider();
            return chromeWebDriverProvider;
        }
        return chromeWebDriverProvider;
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
