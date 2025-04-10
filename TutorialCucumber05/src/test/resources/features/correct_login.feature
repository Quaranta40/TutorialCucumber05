Feature: Login sulla pagina Practice Test Automation

  Background: Login con credenziali varie
    Given L'utente naviga alla pagina di login "https://practicetestautomation.com/practice-test-login/"

  Scenario: Login con credenziali VALIDE
    When L'utente inserisce "student" nel campo username
    And L'utente inserisce "Password123" nel campo password
    And L'utente preme il pusante di Submit
    Then L'utente deve essere loggato con successo
    And la pagina deve mostrare il pulsante di Logout
