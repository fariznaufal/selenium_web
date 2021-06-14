@regression @filter @berrybenka

  Feature: Filter Successfully
    Scenario: Filter barang successfully
      Given user access page "https://berrybenka.com/"
      When user click the button masuk daftar
      Then user input the email "nabilaptrsnyj@gmail.com"
      And user input the password "Yunhojaejoong22"
      And user click masuk button
      And user click the search button
      And user input search barang "flats" click enter
      And user click filter checkbutton item flats
      Then verify the filter success