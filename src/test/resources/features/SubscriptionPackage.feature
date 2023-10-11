Feature: Subscription package feature
  Scenario: Subscription package page title
    Given User is on Subscription package page
    When Subscriptions package page is displayed
    Then Page title should be "stc tv | Watch Movies, Series & Live TV - Enjoy Free Trial"

  Scenario: Subscription Package Country KSA and Language Is English
    Given User is on Subscription package page
    When Country is "KSA"
    And Language is "العربية"
    Then Lite Plan Should be Displayed And Price is "15 SAR/month"
    And Classic Plan Should be Displayed And Price is "25 SAR/month"
    And Premium Plan Should be Displayed And Price is "60 SAR/month"

  Scenario: Subscription Package Country Bahrain and Language Is English
    Given User is on Subscription package page
    When Country is "Bahrain"
    And Language is "العربية"
    Then Lite Plan Should be Displayed And Price is "2 BHD/month"
    And Classic Plan Should be Displayed And Price is "3 BHD/month"
    And Premium Plan Should be Displayed And Price is "6 BHD/month"

  Scenario: Subscription Package Country Kuwait and Language Is English
    Given User is on Subscription package page
    When Country is "Kuwait"
    And Language is "العربية"
    Then Lite Plan Should be Displayed And Price is "1.2 KWD/month"
    And Classic Plan Should be Displayed And Price is "2.5 KWD/month"
    And Premium Plan Should be Displayed And Price is "4.8 KWD/month"

