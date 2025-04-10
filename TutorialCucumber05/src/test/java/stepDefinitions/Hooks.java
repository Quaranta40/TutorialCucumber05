package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class Hooks {

    public static WebDriver driver;
    public static WebDriverWait wait;
    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void setupScenario(Scenario scenario) {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            System.out.println("WebDriver inizializzato correttamente.");
            logger.info("WebDriver inizializzato correttamente.");
        }
        if (wait == null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            System.out.println("WebDriverWait inizializzato correttamente.");
            logger.info("WebDriverWait inizializzato correttamente.");
        }
        System.out.println("--- Inizio scenario: " + scenario.getName() + " ---");
        logger.info("--- Inizio scenario: '{}' ---", scenario.getName());
    }

    @After
    public void teardownScenario(Scenario scenario) {
        if (driver != null) {
            driver.quit();
            driver = null;
            wait = null;
            System.out.println("WebDriver chiuso e azzerato.");
            logger.info("WebDriver chiuso e azzerato.");
        }
        System.out.println("--- Fine scenario: " + scenario.getName() + " ---");
        logger.info("--- Fine scenario: '{}' ---", scenario.getName());
        if (scenario.isFailed()) {
            System.out.println("ATTENZIONE: Il test NON è andato a buon fine!");
            logger.error("Il test '{}' è FALLITO.", scenario.getName());
        } else {
            System.out.println("Il test è stato eseguito con successo.");
            logger.info("Il test '{}' è PASSATO.", scenario.getName());
        }
    }
}
