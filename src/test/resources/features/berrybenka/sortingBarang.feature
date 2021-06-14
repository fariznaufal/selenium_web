@regression @sorting @berrybenka

  Feature: Sorting Barang
    Scenario: Sorting Barang Successfully
      Given user access page berrybenka "https://berrybenka.com/"
      When user click the button masuk daftar
      Then user input the email "nabilaptrsnyj@gmail.com"
      And user input the password "Yunhojaejoong22"
      And user click masuk button
      And user select sort by dropdown
      Then user verify sorting barang successfully
