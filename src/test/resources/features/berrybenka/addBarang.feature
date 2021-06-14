@regression @addbarang @berrybenka

  Feature: Add Barang
    Scenario: Add Barang Successfully
      Given user access page "https://berrybenka.com/"
      When user click the button masuk daftar
      Then user input the email "nabilaptrsnyj@gmail.com"
      And user input the password "Yunhojaejoong22"
      And user click masuk button
      Then user click barang
      And user click warna barang
      And user click ukuran barang
      And user click beli sekarang button
      Then verify add barang successfully