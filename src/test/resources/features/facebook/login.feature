@login @facebook

Feature: Login Facebook

  Scenario Outline: Negative case login facebook
    Given user access page "https://www.facebook.com"
    When user input email <emailOrPhoneNumber>
    And user input password <password>
    And user click login button
    Then system display alert box

    Examples:
      | emailOrPhoneNumber   | password   |
      | "xxxxxxxx@gmail.com" | "123NNMCC" |
      | "aaaaaa@gmail.com"   | "123NNMCC" |