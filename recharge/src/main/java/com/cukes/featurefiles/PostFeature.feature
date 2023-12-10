Feature: Post Feature
    This is a test to checkout the Features


Scenario: Print a Text to Console
    Given User should be logged in
    And Should be present on the wall
    When I tpe the text in the text box
    And Click on the post button
    Then The message should get posted

Scenario: Post a video on user wall
    Given User should be logged in
    And Should be present on the wall
    When User supplies the youtube link in the text box
    And Click on post button
    Then Video should get posted on the users wall
    And The video should have a proper thumbnail