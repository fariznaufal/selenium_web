@regression @AddToCart @sociolla

Feature: Add to cart Sociolla

  Scenario: Add to cart
    Given user access page "https://www.soco.id"
    When user click MASUK button sociolla
    And user input email login "ihfalala@gmail.com"
    And user input password login "2desember1998"
    And user click login button sociolla
    And user input barang "toner" and enter
    And user click product name
    And user click quantity
    And user click buy now button
    And user click checkout button
    Then verify buy now sociolla

