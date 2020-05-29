Feature: Verify hearts' color and wishlist

  Scenario:
    Given I get email from Trashmail and navigate to booking
    When search hotels by case 3
    And mark first and last hotel as selected
    Then I verify that hotel's icon is red
    And wishlist contains selected hotels
    And close driver
