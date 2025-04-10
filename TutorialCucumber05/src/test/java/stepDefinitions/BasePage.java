package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Classe di supporto con i metodi comuni di Selenium/WebDriver.
 * NON contiene Step Definitions e NON contiene @Before/@After.
 */
public class BasePage {

    protected WebDriver driver = Hooks.driver;
    protected WebDriverWait wait = Hooks.wait;

    public BasePage() {
        // se occorre logica di inizializzazione
    }

    public void openPage(String url) {
        driver.get(url);
    }

    protected void print(String string) {
        System.out.println(string);
    }

    protected void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void click(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }

    protected void enterText(WebElement element, String text) {
        waitForElementToBeVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    protected String getElementText(WebElement element) {
        waitForElementToBeVisible(element);
        return element.getText();
    }
}
