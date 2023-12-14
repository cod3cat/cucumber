@login
Feature: Webdriver University - Login Feature
  This feature allows testing of login scenarios

  Background:
    Given I access the webdriver university login page

  Scenario: Validate Successful Login
    When I enter a username "webdriver"
    And I enter a password "webdriver123"
    * I click on the login button
    Then I should bee presented with the successful login message

  Scenario: Validate Unsuccessful Login
    When I enter a username "webdriver"
    And I enter a password "webdriver12"
    * I click on the login button
    Then I should bee presented with the unsuccessful login message

  @outline
  Scenario Outline: Validate Successful & Unsuccessful login message
    When I enter a username <username>
    And I enter a password <password>
    * I click on the login button
    Then I should be presented with the validation message <message>

    Examples:
      | username   | password     | message              |
      | webdriver  | webdriver123 | validation succeeded |
      | webdriver  | webdriver1   | validation failed    |
      | webdriver1 | webdriver123 | validation failed    |