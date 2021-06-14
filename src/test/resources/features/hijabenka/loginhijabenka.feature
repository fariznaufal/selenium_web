@regression @login @hijabenka

Feature: Login hijabenka
  Scenario Outline: Negative case login hijabenka
    Given user access page "https://hijabenka.com/"
    When user click on button login
    Then input the email "<email>"
    And user the input password "<password>"
    And user click on login register button
    Examples:
      | email                     | password   |
      |                           | AA15a186   |
      | bubukucing7@gmail.com     | 12345      |
      |                           |            |
      | bubukucing7@gmail.com     |            |

  Scenario: Positive case login hijabenka
    Given user access page "https://hijabenka.com/"
    When user click on button login
    Then input the email "syafiraindah7@gmail.com"
    And user the input password "AA15a186"
    And user click on login register button
    Then verify the login
