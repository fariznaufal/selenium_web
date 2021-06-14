@regression @search @berrybenka

  Feature: Search Barang
    Scenario : Search Barang Successfully
      Given user access page "https://berrybenka.com/"
      When user click the button masuk daftar
      Then user input the email "nabilaptrsnyj@gmail.com"
      And user input the password "Yunhojaejoong22"
      And user click masuk button
      Then user click the search button
      And user input search barang "heels" and click enter
      Then verify the barang search "heels"
