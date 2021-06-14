@regression @login @hijabenka

Feature: Sorting Item hijabenka
  Scenario: Case sorting item hijabenka
    Given user access page "https://hijabenka.com/"
    When user click on button login
    Then input the email "syafiraindah7@gmail.com"
    And user the input password "AA15a186"
    And user click on login register button
    And user click on search button
    And user input search item "shoes" and click enter
    And user select sorting "termurah"
    Then verify the sorting