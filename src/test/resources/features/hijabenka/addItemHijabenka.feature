@regression @login @hijabenka

Feature: Add Item hijabenka
  Scenario: Case add item hijabenka
    Given user access page "https://hijabenka.com/"
    When user click on button login
    Then input the email "syafiraindah7@gmail.com"
    And user the input password "AA15a186"
    And user click on login register button
    And Add the barang and checkout
    Then verify the item Checkout