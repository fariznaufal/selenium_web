@regression @SearchBar @matahari

Feature: Search Bar
  Scenario Outline: Search many item
    Given user access page "https://www.matahari.com/"
    And user click link navbar login matahari
    When user input email "ariefsusnawati3636@gmail.com" matahari
    And user input password "susna3636636" matahari
    And user click login button matahari
    And user input search bar <SB>
    And user click search Button
    Then verify search result with keyword matahari <keyword>
    Examples:
      | SB       |keyword |
      | "baju"   |"baju"  |

