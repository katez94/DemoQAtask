package org.zaikina.framework.utils.webdriver.provider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.zaikina.framework.utils.webdriver.WebDriverConfigManager;

public class FireFoxWebDriverProvider implements WebDriverProvider {
    private static FireFoxWebDriverProvider fireFoxWebDriverProvider;
    private WebDriver driver;

    private FireFoxWebDriverProvider() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(WebDriverConfigManager.getInstance().getUrl());
    }

    public static FireFoxWebDriverProvider getInstance() {
        if (fireFoxWebDriverProvider == null) {
            fireFoxWebDriverProvider = new FireFoxWebDriverProvider();
            return fireFoxWebDriverProvider;
        }
        return fireFoxWebDriverProvider;
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
