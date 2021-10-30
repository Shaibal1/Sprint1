Feature: Home

 #TC-17: Verify past date and back button on Current month's calendar is disabled
  @sprint @calendar
  Scenario: Verify past date and back button on Current month's calendar is disabled
    Given I am on Homepage
    When I click on Check In Calendar
    Then I verify past dates are disabled
    And Back button on current month is disabled
    And I quit the webpage

#TC-18: Verify user can update number of guests on Home page
  @sprint @guest-count-update
  Scenario: Verify user can update number of guests on Home page
    Given I am on Homepage
    When I click on Guests field
    And I add 2 adults
    And I add 2 children
    And I select the first child age as 4
    And I select the second child age as <1
    Then I verify on rooms pop-up the number of adults and children match the number I selected
    And I click on Apply button
    Then I verify the total number of guests in sum of adults and children match the number I selected
    And I quit the webpage
  #TC-19: Verify CHANGE DATES button is displayed at the end of search results
  @sprint @change-dates-displayed @change-dates-enabled
  Scenario: Verify CHANGE DATES button is displayed at the end of search results
    Given I am on Homepage
    When I enter "bora" in destination
    And I select “Bora Bora, Leeward Islands, French Polynesia” from auto suggestion
    And I click on Check In Calendar
    And I click Next button to select December month
    And I select December 1,2021 as Check-In
    And I click on Check Out Calendar
    And I select December 16,2021 as Check-Out
    And I click on Apply button
    And I click on Search button
    Then I verify at the end of search results, Change Dates button is displayed
    And I verify Change Dates button is enabled
    And I quit the webpage
  #TC-20 Verify TermsAndConditions link and PrivacyStatements link open correct page on new tab
  @sprint @terms-and-conditions-new-tab @privacy-statement-new-tab @window-handles
  Scenario: Verify TermsAndConditions link and PrivacyStatements link open correct page on new tab
    Given I am on Homepage
    When I click on Sign in link
    And I click on Sign up link
    And I click on Terms and Conditions link
    Then I verify Terms and Conditions page opens in new tab
    And I close Terms and Conditions page and switch to Home page
    And I click on Privacy Statement link
    Then I verify Privacy Statement page opens in new tab
    And I quit the webpage
  #TC-21: Verify error message for invalid sign in credentials
  @sprint @error-message @sign-in @invalid-credentials
  Scenario: Verify error message for invalid sign in credentials
    Given I am on Homepage
    When I click on Sign in link
    And I enter 'test@abc.com' email
    And I enter '1234' password
    And I click on "Sign in" button
    Then I verify error message is displayed
    And I quit the webpage
