@regression @register @matahari

Feature: Register Matahari
Scenario: Register Negative case
Given user access page "https://www.matahari.com/"
And user click link navbar login matahari
When user click link register
And user input register email matahari "xxxxgmail.com"
And user input register nama lengkap matahari "xxxxx"
And user input register telephone lengkap matahari "12345"
And user input register date "01/12/2020"
And user input register password "xxxxxxxxxxxxx"
And user click gender matahari
And user click register button matahari
Then Verify alert matahari