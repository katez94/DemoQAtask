package org.zaikina.framework.utils.webdriver;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class WebDriverConfigManager {
    private static WebDriverConfigManager config;
    private static final String CONFIG_JSON_FILE_DEFAULT = "src/main/resources/config.json";
    private static final String CONFIG_JSON_FILE_USER_PATH = "src/test/resources/config.json";
    private String browser;
    private boolean maximizedWindow;
    private String url;

    private WebDriverConfigManager() {
    }

    public static WebDriverConfigManager getInstance() {
        if (config == null) {
            try {
                config = getConfigFromJson(CONFIG_JSON_FILE_USER_PATH);
            } catch (RuntimeException e) {
                config = getConfigFromJson(CONFIG_JSON_FILE_DEFAULT);
            }
            return config;
        }
        return config;
    }

    private static WebDriverConfigManager getConfigFromJson(String fileName) {
        Gson gson = new Gson();
        try {
            return gson.fromJson(new FileReader(fileName), WebDriverConfigManager.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Json config not found!");
        }
    }

    public String getBrowser() {
        return browser;
    }

    public boolean getMaximizedWindow() {
        return maximizedWindow;
    }

    public String getUrl() {
        return url;
    }
}
