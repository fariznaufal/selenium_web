@regression @login @hijabenka

Feature: Add address
  Scenario Outline: Negative case add address hijabenka
    Given user access page "https://hijabenka.com/"
    When user click on button login
    Then input the email "syafiraindah7@gmail.com"
    And user the input password "AA15a186"
    And user click on login register button
    And user click on account button
    And user click on account setting button and click on add new address
    And user fill the field <address> <postalCode> <phone>
    Then verify the address
    Examples:
    | address        | postalCode | phone         |
    | "jl.aceh raya" |  "abc"     | "08158830895" |
    | "jl.aceh raya" |            | "08158830895" |
    | "jl.aceh raya" | "15810"    |               |
    | "            " | "15810"    | "08158830895" |
    |                |            |               |

  Scenario: Positive case add address hijabenka
    Given user access page "https://hijabenka.com/"
    When user click on button login
    Then input the email "syafiraindah7@gmail.com"
    And user the input password "AA15a186"
    And user click on login register button
    And user click on account button
    And user click on account setting button and click on add new address
    And user fill the field "jl.aceh raya" "15810" "08158830895"
    Then verify the address