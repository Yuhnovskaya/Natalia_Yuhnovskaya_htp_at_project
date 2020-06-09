Feature: Cinema

Scenario: Search movie
Given I open an app
When I search for <search word> word
Then I see the list of movie items
And each item name or description contains <search word>

Scenario: Login app
Given I open an app
When I login with <login> and <password>
Then I can see Red Carpet Club <level> in upper right corner

Scenario Outline: Login app blank field
Given I open an app
When I left blank <field> field
Then I see <message> message

Examples:
|field    |message                            |
|login    |Необходимо заполнить поле E-mail |
|password |Необходимо заполнить поле Пароль |

Scenario: Login app no such user
Given I open an app
When I login with wrong <login> and <password>
Then I see <message> message