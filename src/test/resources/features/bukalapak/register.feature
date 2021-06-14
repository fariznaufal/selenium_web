@regression @bukalapak @register

Feature: Register Bukalapak

  Scenario: Negative case register bukalapak invalid email format
    Given user access page "https://www.bukalapak.com/register"
    And user input register email "testingmail"
    Then verify if email error message is shown