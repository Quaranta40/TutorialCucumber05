Feature: Login sulla pagina Practice Test Automation

  Background: Login con credenziali varie

  Scenario: Login con credenziali ERRATE
    Given L'utente naviga alla pagina di login "https://practicetestautomation.com/practice-test-login/"
    When inserisce le seguenti credenziali errate e preme Submit:
      | username      | password      |
      | wrongUsername | password123   |
      | student       | wrongPassword |
    Then L'utente NON deve essere loggato con successo
    And la pagina deve mostrare il messaggio di errore
