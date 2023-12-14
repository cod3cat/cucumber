@contact-us
Feature: Webdriver University - Contact Us Page

  @unique
  Scenario: Validate Successful Submission - Unique Data
    Given I access the webdriver university contact us page
    When I enter a unique first name
    And I enter a unique last name
    * I enter a unique email address
    * I enter a unique comment
    * I click on the submit button
    Then I should be presented with a successful contact us submission message

  @specific
  Scenario: Validate Successful Submission - Specific Data
    Given I access the webdriver university contact us page
    When I enter a specific first name john
    And I enter a specific last name Doe
    * I enter a specific email address sample@test.com
    * I enter a specific comment "This is a test message"
    * I click on the submit button
    Then I should be presented with a successful contact us submission message
