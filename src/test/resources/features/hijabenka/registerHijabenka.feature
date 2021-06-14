@regression @login @hijabenka

Feature: Register hijabenka
  Scenario Outline: case register hijabenka
    Given user access page "https://hijabenka.com/"
    When user click on button login
    Then user click on button make account
    Then input first name "<first name>" and last name "<last name>"
    And user input new email "<email new>"
    And user input new password "<password new>" and retype password "<retype pass>"
    And user click on button make new account
    Examples:
      | first name                | last name       | email new               | password new| retype pass |
      |                           | Indah           | syafira17@gmail.com     | 12345678    | 12345678    |
      | Syafira                   |                 | syafira17@gmail.com     | 12345678    | 12345678    |
      | Syafira                   | Indah           |                         | 12345678    | 12345678    |
      | Syafira                   | Indah           | syafira17gmail.com      | 12345678    | 12345678    |
      | Syafira                   | Indah           | syafira17@gmail.com     |             | 12345678    |
      | Syafira                   | Indah           | syafira17@gmail.com     | 12345678    |             |
      | Syafira                   | Indah           | syafira17@gmail.com     | 12345678    | 56728392    |
      | Syafira                   | Indah           | syafira17@gmail.com     |             |             |
      |                           |                 |                         |             |             |