Feature: LoginbookingTest

  Scenario:
    Given I get email from Trashmail, navigate booking and login
    When I enter my account
    Then verify that button log out exists

