Feature: httpTestSteps

  Scenario Outline: Check user by name
    Given I start execution httpTest
    When I search user by <case>
    Then I verify that I got <expected>

Examples:
|case|expected|
|0   |"src/test/resources/httpExpectedData/allUsers"|
|1   |"src/test/resources/httpExpectedData/shortFullName"|
|2   |"src/test/resources/httpExpectedData/shortPartialName"|
|3   |"src/test/resources/httpExpectedData/longFullName"|
|4   |"src/test/resources/httpExpectedData/longPartialName"|