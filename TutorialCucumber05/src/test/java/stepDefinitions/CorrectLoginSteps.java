package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

/**
 * Classe con Step Definitions specifiche per il login corretto.
 * Estende BasePage, che però NON contiene più hook o step definitions.
 */
public class CorrectLoginSteps extends BasePage {

    private final By usernameLocator = By.id("username");
    private final By passwordLocator = By.id("password");
    private final By submitLocator = By.id("submit");
    private final By msgSuccessLocator = By.xpath("//h1[contains(text(), 'Logged In')]");
    private final By logoutLocator = By.xpath("//a[contains(text(), 'Log out')]");

    @Given("L'utente naviga alla pagina di login {string}")
    public void openLoginPage(String urlPaginaLogin) {
        openPage(urlPaginaLogin);
        print("URL aperto correttamente");
    }

    @When("L'utente inserisce {string} nel campo username")
    public void putUsername(String username) {
        //  WebElement usernameField = driver.findElement(usernameLocator);
        enterText(driver.findElement(usernameLocator), username);
        print("Username inserito");
    }

    @And("L'utente inserisce {string} nel campo password")
    public void putPassword(String password) {
        // WebElement passwordField = driver.findElement(passwordLocator);
        enterText(driver.findElement(passwordLocator), password);
        print("Password inserita");
    }

    @And("L'utente preme il pusante di Submit")
    public void clickSubmit() {
        // WebElement submitButton = driver.findElement(submitLocator);
        click(driver.findElement(submitLocator));
        print("Submit button cliccato");
    }

    @Then("L'utente deve essere loggato con successo")
    public void loginCorretto() {
        //   WebElement messaggioSuccesso = driver.findElement(msgSuccessLocator);
        print("La pagina contiene il messaggio di successo: " + getElementText(driver.findElement(msgSuccessLocator)));
    }

    @And("la pagina deve mostrare il pulsante di Logout")
    public void checkLogoutButton() {
        // WebElement logoutButton = driver.findElement(logoutLocator);
        if (driver.findElement(logoutLocator).isDisplayed()) {
            print("Logout button presente, Login effettuato con successo");
        }
    }
}
