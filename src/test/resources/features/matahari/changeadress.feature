@regression @changeaddress @matahari

Feature: Add address

  Scenario Outline: add item with search
    Given user access page <url>
    And user click link navbar login matahari
    When user input email <email> matahari
    And user input password <password> matahari
    And user click login button matahari
    And user click link profil
    And user click Add Address
    And user input add address <label> <name> <telephone> <adres> <zipcode>
    And user select option province, city, subdistrict
    And user click save button
    Then verify change address
    Examples:
      | url                         | email                          | password       | label   | name        | telephone  | adres                     | zipcode |
      | "https://www.matahari.com/" | "ariefsusnawati3636@gmail.com" | "susna3636636" | "no.15" | "syaifudin" | "08776765" | "jl. Serma zainal Abidin" | "31512" |



