@SO
Feature: login with different

Scenario Outline:
Given user on "<url>" page
When  user tries to login with username "<username>"
Then  user tries to login with password "<password>"
And   login status should be "<status>"

Examples:
| url                           | username          | password   | status |
| http://opencart.abstracta.us/ | hasan123          | linkedin1  | false  |
| http://opencart.abstracta.us/ |                   | linkedin12 | false  |
| http://opencart.abstracta.us/ | hasan1235         |            | false  |
| http://opencart.abstracta.us/ | deneme@deneme.com | deneme     | true   |
| http://opencart.abstracta.us/ | hasan1273         | linkedin5  | false  |
| http://opencart.abstracta.us/ | hasan1238         | linkedin6  | false  |