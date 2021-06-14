@regression @bukalapak @newregister

Feature: Register Bukalapak

  Scenario: New Register Bukalapak
    Given user access page "https://www.bukalapak.com/register"
    And new user input fullname "fariz naufal"
    And new user input email "fariztesting123@testing.com"
    And new user click radio laki
    And new user input password "pasword123"
    And new user click submit