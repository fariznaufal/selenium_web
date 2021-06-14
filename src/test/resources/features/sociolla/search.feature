@regression @search @sociolla
Feature: Search Sociolla

  Scenario: Search
    Given user access page "https://www.soco.id"
    When user click MASUK button sociolla
    And user input email login "ihfalala@gmail.com"
    And user input password login "2desember1998"
    And user click login button sociolla
    And user input barang "toner" and enter
    Then verify product name by keyword "toner"