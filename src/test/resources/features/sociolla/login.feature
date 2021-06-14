@regression @login @sociolla

Feature: Login Sociolla
  Scenario Outline: negative case login sociolla
    Given user access page "https://www.soco.id"
    When user click MASUK button sociolla
    And user input email login <emailOrUsername>
    And user input password login <password>
    Then user click login button sociolla
    Examples:
      | emailOrUsername       | password              |
      | "ihfalala@gmail.com"  | ""                    |
      | ""                    | "2desember1998"       |
      | "ihfafirli@gmail.com" | "2desember1998"       |
      | "ihfalala@gmail.com"  | "2desember"           |

  Scenario: positive case login sociolla
    Given user access page "https://www.soco.id"
    When user click MASUK button sociolla
    And user input email login "ihfalala@gmail.com"
    And user input password login "2desember1998"
    And user click login button sociolla
    Then verify profile sociolla


