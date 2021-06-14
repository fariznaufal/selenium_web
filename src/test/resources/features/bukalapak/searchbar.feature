@regression @bukalapak @searchbar

Feature: Searchbar bukalapak

  Scenario: Searchbar test case bukalapak and verify result with keyword
    Given user access page "https://www.bukalapak.com/login"
    When user input email bukalapak "zworys@ymail.com"
    And user input password bukalapak "asdf123"
    And user click on login button bukalapak
    And user input search with keyword "piano" and click on search submit button
    Then verify search result with keyword "piano"