@regression @bukalapak @login

Feature: Login Bukalapak

  Scenario Outline: Negative case login bukalapak
    Given user access page <url>
    When user input email bukalapak <emailOrPhoneNumber>
    And user input password bukalapak <password>
    And user click on login button bukalapak
    Then verify if system displayed alert box bukalapak
    Examples:
      | url                               | emailOrPhoneNumber      | password   |
      | "https://www.bukalapak.com/login" | "xxxxxxxx123@gmail.com" | "123NNMCC" |
      | "https://www.bukalapak.com/login" | "asd123@asd.com"        | "qwe"      |

  Scenario: Forgot password button
    Given user access page "https://www.bukalapak.com/login"
    When user click on forgot password button bukalapak
    Then compare current url with "https://www.bukalapak.com/password_resets/new"

  Scenario: Register button
    Given user access page "https://www.bukalapak.com/login"
    When user click on register button bukalapak
    Then verify if user directed to register page

  Scenario: Positive case login bukalapak with enter key
    Given user access page "https://www.bukalapak.com/login"
    When user input email bukalapak "zworys@ymail.com"
    And user input password bukalapak "asdf123"
    And user pressed Enter key on Password field bukalapak
    Then verify if user successfully logged in