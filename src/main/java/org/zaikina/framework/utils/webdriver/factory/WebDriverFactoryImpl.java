package org.zaikina.framework.utils.webdriver.factory;

import org.openqa.selenium.WebDriver;
import org.zaikina.framework.utils.webdriver.WebDriverConfigManager;
import org.zaikina.framework.utils.webdriver.provider.ChromeWebDriverProvider;
import org.zaikina.framework.utils.webdriver.provider.FireFoxWebDriverProvider;

import java.util.Locale;

public class WebDriverFactoryImpl implements WebDriverFactory {
    private final WebDriverConfigManager webDriverConfigManager = WebDriverConfigManager.getInstance();

    @Override
    public WebDriver getDriver() {
        String brName = webDriverConfigManager.getBrowser().toLowerCase(Locale.ROOT);
        switch (brName) {
            case ("chrome"):
                return ChromeWebDriverProvider.getInstance().getWebDriver();
            case ("firefox"):
                return FireFoxWebDriverProvider.getInstance().getWebDriver();
            default:
                throw new IllegalStateException("Unknown browser name");
        }
    }
}
