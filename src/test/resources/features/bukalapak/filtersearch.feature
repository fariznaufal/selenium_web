@regression @bukalapak @filtersearch

Feature: Filter Search Bukalapak

  Scenario: Filter search bukamall in bukalapak
    Given user access page "https://www.bukalapak.com/login"
    When user input email bukalapak "zworys@ymail.com"
    And user input password bukalapak "asdf123"
    And user click on login button bukalapak
    And user input search with keyword "keyboard" and click on search submit button
    And user scroll to bukamall checkbox
    And user click on bukamall filter
    Then verify bukamall icon

  Scenario: Filter sorting in bukalapak
    Given user access page "https://www.bukalapak.com/login"
    When user input email bukalapak "zworys@ymail.com"
    And user input password bukalapak "asdf123"
    And user click on login button bukalapak
    And user input search with keyword "keyboard" and click on search submit button
    And user select sorting by "terlaris"
    Then verify product sorting