package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class WrongLoginSteps extends BasePage {

    @When("inserisce le seguenti credenziali errate e preme Submit:")
    public void putWrongCredentialAndSubmit(DataTable dataTable) throws InterruptedException {

        // Converti la tabella Gherkin in una lista di mappe
        List<Map<String, String>> credenziali = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> riga : credenziali) {
            String username = riga.get("username");
            String password = riga.get("password");
            print("Username: " + username + ", Password: " + password);

            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement submitButton = driver.findElement(By.id("submit"));

            enterText(usernameField, username);
            enterText(passwordField, password);
            click(submitButton);

            print("Submit button cliccato");
            Thread.sleep(3000);
        }
    }

    @Then("L'utente NON deve essere loggato con successo")
    public void loginErrato() {
        print("Risultato autenticazione: FALLIMENTO");
    }

    @And("la pagina deve mostrare il messaggio di errore")
    public void errorMessage() {
        WebElement messaggioErrore = driver.findElement(By.xpath("//*[@id=\"error\"]"));
        print("La pagina contiene il messaggio d'errore: " + getElementText(messaggioErrore));
    }
}
