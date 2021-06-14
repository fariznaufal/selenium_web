@regression @filter @matahari
Feature: Filter Barang
  Scenario: filter item with search
    Given user access page "https://www.matahari.com/"
    And user click link navbar login matahari
    When user input email "ariefsusnawati3636@gmail.com" matahari
    And user input password "susna3636636" matahari
    And user click login button matahari
    And user input search bar "sepatu"
    And user click search Button
    And user click filter color
    And user chose colors
    Then verify item