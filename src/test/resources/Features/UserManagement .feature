Feature: OrangeHRM User Management

  Scenario: Add and delete a user
    Given I am on the OrangeHRM login page
    When I login with "Admin" and "admin123"
    And I navigate to Admin tab
    Then I note the number of records
    When I add a new user with "JohnSmith" and "john123"
    Then I verify the number of records increased by 1
    When I search for user "JohnSmith"
    And I delete the user "JohnSmith"
    Then I verify the number of records decreased by 1