@regression @login @hijabenka

Feature: Search Item hijabenka

  Scenario: Case search item hijabenka
    Given user access page "https://hijabenka.com/"
    When user click on button login
    Then input the email "syafiraindah7@gmail.com"
    And user the input password "AA15a186"
    And user click on login register button
    And user click on search button
    And user input search item "outer" and click enter
    Then verify the item search "outer"




