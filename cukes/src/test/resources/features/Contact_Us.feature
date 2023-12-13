Feature: Webdriver University - Contact Us Page

  Scenario: Validate Successful Submission - Unique Data
    Given I access the webdriver university contact us page
    When I enter a unique first name
    And I enter a unique last name
    * I enter a unique email address
    * I enter a unique comment
    * I click on the submit button
    Then I should be presented with a successful contact us submission message