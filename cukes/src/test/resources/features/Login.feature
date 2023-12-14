@login
Feature: Webdriver University - Login Feature
  This feature allows testing of login scenarios

  Scenario: Validate Successful Login
    Given I access the webdriver university login page
    When I enter a username "webdriver"
    And I enter a password "webdriver123"
    * I click on the login button
    Then I should bee presented with the successful login message

  Scenario: Validate Unsuccessful Login
    Given I access the webdriver university login page
    When I enter a username "webdriver"
    And I enter a password "webdriver12"
    * I click on the login button
    Then I should bee presented with the unsuccessful login message