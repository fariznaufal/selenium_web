@regression @filter @sociolla
  Feature: filter search sociolla

    Scenario: filter terlaris sociolla
      Given user access page "https://www.soco.id"
      When user click MASUK button sociolla
      And user input email login "ihfalala@gmail.com"
      And user input password login "2desember1998"
      And user click login button sociolla
      And user input barang "toner" and enter
      And user click Brand Avoskin and click apply button
      Then verify filter sociolla



