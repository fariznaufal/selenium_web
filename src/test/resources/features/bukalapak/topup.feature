@regression @bukalapak @topup

Feature: Topup pulsa prabayar bukalapak

  Scenario: Searchbar test case bukalapak and verify result with keyword
    Given user access page "https://www.bukalapak.com/login"
    When user input email bukalapak "zworys@ymail.com"
    And user input password bukalapak "asdf123"
    And user click on login button bukalapak
    And user click on menu topup pulsa prabayar
    And user input nomor telepon with "085715000401" and select nominal
    And user click on beli pulsa button
    Then verify nomor telepon