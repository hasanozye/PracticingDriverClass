Feature: login functionality

  Scenario: Validating Forget Password Link
    Given user on homepage
    When  user clicks My Account Link
    And   user clicks Login Link
    Then  login page should be visible

    When  user fills login form with the following datas
      | username | deneme@deneme.com |
      | password | deneme            |

    And   user clicks login button
    Then  login should be successfull