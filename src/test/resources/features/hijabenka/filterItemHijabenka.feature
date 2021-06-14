@regression @login @hijabenka

Feature: Filter item hijabenka
  Scenario: Case filter item hijabenka
    Given user access page "https://hijabenka.com/"
    When user click on button login
    Then input the email "syafiraindah7@gmail.com"
    And user the input password "AA15a186"
    And user click on login register button
    And user click on search button
    And user input search item "shoes" and click enter
    And user click on item filter button
    Then verify the filter