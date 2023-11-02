Feature: login functionality

  Background: Login to site
    Given user on homepage

  Scenario: Logging in to the account
    When  user clicks My Account Link
    And   user clicks Login Link
    Then  login page should be visible

    When  user fills login form with the following datas
      | username | deneme@deneme.com |
      | password | deneme            |

    And   user clicks login button
    Then  login should be successfull

    Scenario: False credentials
      When user clicks My Account Link
      And user clicks Login Link
      Then login page should be visible

      When user fills login form with the following datas
        | username | deneme@deneme.com |
        | password | xyzabc123         |
      And user clicks login button
      Then login should be fail