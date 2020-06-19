Feature: ParisBookingTest

  Scenario Outline:
    Given I navigate to booking
    When I search hotels in case <number>
    And <test case>
    Then I check that <result>

    Examples:
    |number|test case                                                       |result                                                                  |
    |0     |define the price of the cheapest hotel                          |the price of the cheapest hotel is lower than min filter price          |
    |1     |define the price of the most expensive hotel                    |the price of the most expensive hotel is higher than max filter price   |
    |2     |paint the background of the tenth hotel green and its text red  |the color of the background is green and the text is red                |






