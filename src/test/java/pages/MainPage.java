package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static tests.BaseTest.driver;
import static tests.BaseTest.getActions;

public class MainPage {
    private final WebElement elementsCard = driver.findElement(By.xpath("//*[contains(@class,'top-card') and .//*[contains(text(),'Elements')]]"));

    public void clickElementsCard() {
        getActions().scrollToElement(elementsCard);
        elementsCard.click();
    }
}
