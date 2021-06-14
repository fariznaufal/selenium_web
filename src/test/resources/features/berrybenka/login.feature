@regression @login @berrybenka

Feature: Login
  Scenario Outline: Positive and negative case login
    Given user access page "https://berrybenka.com/"
    When user click the button masuk daftar
    Then user input the email "<email>"
    And user input the password "<password>"
    And user click masuk button
    Then verify the login page
    Examples:
    | email | password |
    | nabilaptrsn@gmail.com   | Yunhojaejoong22 |
    | nabilaptrsnyj@gmail.com | Yunhojaejoong23 |
    | nabilaptrsn@gmail.com   | yunjae          |
    | nabilaptrsnyj@gmail.com | Yunhojaejoong22 |







