Feature: Check Subscription Package

  @TestDD
  Scenario Outline: Subscription Package Country KSA and Language Is English
    Given User is on Subscription package page
    When Country is <country>
    And I select language <language>
    Then Lite Plan Should be Displayed And Price is <country>
    And Classic Plan Should be Displayed And Price is <country>
    And Premium Plan Should be Displayed And Price is <country>


    Examples:
      | country | language  |
      | "KSA"   | "العربية" |
      | "Kuwait"    | "العربية" |
      | "Bahrain"    | "العربية" |