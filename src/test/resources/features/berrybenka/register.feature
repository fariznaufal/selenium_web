@regression @register @berrybenka

 Feature: Register Berrybenka Negative Case
    Scenario Outline: Register Berrybenka for negative case
    Given user access page "https://berrybenka.com/"
    When user click the button masuk daftar
    Then user click the button daftar berrybenka
    Then user input nama depan "<nama depan>"
    And user input nama belakang "<nama belakang>"
    And user input email for register "<email>"
    And user input password for register "<password>"
    And user input ketik ulang password "<ketik ulang password>"
    And user click buat akun button
    Then verify register success

    Examples:
    | nama depan | nama belakang | email | password | ketik ulang password |
    | | nana | nununana@gmail.com | nununana | nununana |
    | nunu | | nununana@gmail.com | nununana | nununana |
    | nunu | nana | | nununana | nununana               |
    | nunu | nana | nununana@gmail.com | | nununana |
