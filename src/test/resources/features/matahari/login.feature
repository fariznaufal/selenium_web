@regression @login @matahari

Feature: Login Matahari

  Scenario Outline: Negative case masukkan email yang salah
    Given user access page "https://www.matahari.com/"
    And user click link navbar login matahari
    When user input email <emailOrPhoneNumber> matahari
    And user input password <password> matahari
    And user click login button matahari

    Examples:

    | emailOrPhoneNumber  | password       |
    | "xxxxxxx@gmail.com" | "susna3636636" |
    | "ariefsusnawati@gmail.com" | "xxxxxxxxx" |
    | "" | "xxxxxxxxx" |
    | "ariefsusnawati@gmail.com" | "" |


    Scenario: Login Positive case
      Given user access page "https://www.matahari.com/"
      And user click link navbar login matahari
      When user input email "ariefsusnawati3636@gmail.com" matahari
      And user input password "susna3636636" matahari
      And user click login button matahari
      Then Verify Profil Picture matahari