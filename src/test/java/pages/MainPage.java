package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.JSUtils;

import static tests.BaseTest.driver;

public class MainPage {
    private final WebElement elementsCard = driver.findElement(By.xpath("//*[contains(@class,'top-card') and .//*[contains(text(),'Elements')]]"));

    public void clickElementsCard() {
        JSUtils.scrollToElement(elementsCard);
        elementsCard.click();
    }
}
