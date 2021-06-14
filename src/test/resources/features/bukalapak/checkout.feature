@regression @bukalapak @checkout

Feature: Checkout Bukalapak

  Scenario: Checkout from item page
    Given user access page "https://www.bukalapak.com/login"
    When user input email bukalapak "zworys@ymail.com"
    And user input password bukalapak "asdf123"
    And user click on login button bukalapak
    And user input search with keyword "keyboard" and click on search submit button
    And user click on item
    And user click on buy now button
    Then verify product name on checkout
    
  Scenario: Checkout multiple item
    Given user access page "https://www.bukalapak.com/login"
    When user input email bukalapak "zworys@ymail.com"
    And user input password bukalapak "asdf123"
    And user click on login button bukalapak
    And user search and add multiple item to cart
      | keyboard |
      | piano    |
      | laptop   |
      | mouse    |
      | monitor  |
    And user click on view cart
    Then verify all product name on checkout
    And user remove all items in cart