Feature: Profile tests2

  Background:
    Given I launched the app
    When I skip the On-boarding flow
    And I tap on continue with free lessons button
    And I wait for 2 seconds
    And I tap on Profile tab
    And I wait for 1 seconds

  # Verify "Already have an account?" text on on the Profile screen for Guest user
  # Verify user should redirected to Login screen when click on "Log in" link on profile screen for Guest user
  @regression
  Scenario Outline:  Verify "Log in" link on the Profile screen for Guest user
    Then I should see "<text>" on Profile screen
    When I tap login link on profile screen
    And I wait for 2 seconds
    Then I should be redirected to Login screen
    And I close the App

      Examples:
        |         text           |
        |Already have an account?|

  @regression
  Scenario Outline:  Verify for Register user "My Overview" text displayed on profile screen
    When I tap login link on profile screen
    When I enter "<username>" and "<password>" on login screen
    And I tap on LOGIN button on login screen
    And I wait for 2 seconds
    And I tap on Profile tab
    And I wait for 1 seconds
    Then I should see Level tag "Newbie" for guest user
    Then I should not see lock icon And see "500" at the end of progress bar
    And I close the App

    Examples:
      |      username     |  password |
      |1608adil@gmail.com |adil16adil |














