@regression @bukalapak @accountsetting

Feature: Account Setting Bukalapak

  Scenario: Change Account Name
    Given user access page "https://www.bukalapak.com/login"
    When user input email bukalapak "zworys@ymail.com"
    And user input password bukalapak "asdf123"
    And user click on login button bukalapak
    And user click on account setting menu and edit profile button
    And user input name with "Fariz Naufal" and click save
    Then verify account name with "Fariz Naufal"