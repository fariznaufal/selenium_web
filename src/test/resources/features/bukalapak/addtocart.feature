@regression @bukalapak @addtocart

Feature: Add to Cart Bukalapak

  Scenario: Add to Cart and Verify Product Name
    Given user access page "https://www.bukalapak.com/login"
    When user input email bukalapak "zworys@ymail.com"
    And user input password bukalapak "asdf123"
    And user click on login button bukalapak
    And user input search with keyword "keyboard" and click on search submit button
#    And user hover product
    And user click on add to cart button
    And user click on view cart
    Then verify product name on cart