@regression @bukalapak @vendorpage

Feature: Searchbar bukalapak

  Scenario: Searchbar test case bukalapak and verify result with keyword
    Given user access page "https://www.bukalapak.com/login"
    When user input email bukalapak "zworys@ymail.com"
    And user input password bukalapak "asdf123"
    And user click on login button bukalapak
    And user input search with keyword "Gantibaterai"
    And user click on vendor page search result
    And user click on follow button
    Then verify popup notice