@regression @regist @sociolla

Feature: Register Sociolla

  Scenario Outline: negative case registrasi sociolla
    Given user access page "https://www.soco.id"
    When user click DAFTAR button sociolla
    And user input firstname <firstName>
    And user input lastname <lastName>
    And user input username <regUsername>
    And user input email regist <regEmail>
    And user input no handphone <noHandphone>
    And user input regist password <password>
    And user click regist button sociolla
    Then system display alert box regist
    Examples:
      | firstName | lastName | regUsername | regEmail                 | noHandphone  | password       |
      | ""        | "lala"   | "firlilala" | "firlilala123@gmail.com" | "8123456789" | "lalalalalala" |
      | "firli"   | ""       | "firlilala" | "firlilala123@gmail.com" | "8123456789" | "lalalalalala" |
      | "firli"   | "lala"   | "lalaihfa"  | "firlilala123@gmail.com" | "8123456789" | "lalalalalala" |
      | "firli"   | "lala"   | "firlilala" | ""                       | "8123456789" | "lalalalalala" |
      | "firli"   | "lala"   | "firlilala" | "xxxxxxxxx"              | "8123456789" | "lalalalalala" |
      | "firli"   | "lala"   | "firlilala" | "firlilala123@gmail.com" | ""           | "lalalalalala" |
      | "firli"   | "lala"   | "firlilala" | "firlilala123@gmail.com" | "abcd"       | "lalalalalala" |
      | "firli"   | "lala"   | "firlilala" | "firlilala123@gmail.com" | "8123"       | "lalalalalala" |
      | "firli"   | "lala"   | "firlilala" | "firlilala123@gmail.com" | "8123456789" | ""             |
      | "firli"   | "lala"   | "firlilala" | "firlilala123@gmail.com" | "8123"       | "lalalalalala" |
