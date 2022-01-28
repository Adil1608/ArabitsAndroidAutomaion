Feature: Profile tests

  Background:
    Given I launched the app
    When I skip the On-boarding flow
    And I tap on continue with free lessons button
    And I wait for 2 seconds
    And I tap on Profile tab
    And I wait for 1 seconds



    #  Verify the Level Tag (Newbie) for a guest user
    #  Verify the Progress bar on the Profile screen for Guest user
  @regression
  Scenario: Verify the user icon with Guest name on the Profile screen for Guest user
    Then I should be able to see user icon on profile screen
    Then I should see guest name on Profile screen
    Then I should see Level tag "Newbie" for guest user
    Then I should see lock icon with "500" at the end of progress bar
    And I close the App



    #Verify setting icon link on the Profile screen for Guest user
  @regression
  Scenario: Verify the edit pencil button on the Profile screen for Guest user
    And I tap setting button on profile screen
    Then I should redirected to Setting screen
    When I tap on back arrow on SETTING screen
    And I wait for 2 seconds
    And I tap on Edit button on Profile screen
    Then I should be navigated to Edit Profile screen
    And I close the App



  @regression
  Scenario Outline: Verify "Create your account" button on the Profile screen for Guest user
    Then I should be able to see "<text>" on profile screen
    And I tap create your account button on profile screen
    And I wait for 2 seconds
    Then I should redirected to Create your account screen
    And I close the App

    Examples:
      |                       text                               |
      |Register now to save your XP and access your full profile!|














