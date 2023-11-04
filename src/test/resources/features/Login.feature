Feature: login functionality

  Background: Login to site
    Given user on homepage

  Scenario: Logging in with true credentials
    When  user clicks My Account Link
    And   user clicks Login Link
    Then  login page should be visible

    When  user fills login form with the following datas
      | username | deneme@deneme.com |
      | password | deneme            |

    And   user clicks login button
    Then  login should be successfull

  Scenario: Logging in with false credentials
    When user clicks My Account Link
    And user clicks Login Link
    Then login page should be visible

    When user fills login form with the following datas
      | username | deneme@deneme.com |
      | password | xyzabc123         |
    And user clicks login button
    Then login should be fail

  Scenario: user searches for product
    When user search "mac"
    Then product count should be 4
@MapsList
  Scenario: Statuses with login attempts
    When user tries to login with list of maps
      | username          | password   | status |
      | hasan123          | linkedin1  | false  |
      |                   | linkedin12 | false  |
      | hasan1235         |            | false  |
      | deneme@deneme.com | deneme     | true   |
      | hasan1273         | linkedin5  | false  |
      | hasan1238         | linkedin6  | false  |
      | hasan1239         | linkedin7  | false  |
      | hasan12310        | linkedin1n | false  |