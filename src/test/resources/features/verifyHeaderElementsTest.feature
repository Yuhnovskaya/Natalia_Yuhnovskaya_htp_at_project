Feature: VerifyHeaderElementsTest

  Scenario Outline: verify that header elements are present
    Given I get email from Trashmail, navigate booking and login
    Then I verify that header element <element> is present
    And close driver

  Examples:
  |element       |
  |account       |
  |airportTaxi   |
  |attractions   |
  |carRents      |
  |country       |
  |flights       |
  |help          |
  |language      |
  |logo          |
  |property      |
  |stay          |
