 # @author Ravikumar Lubdhi
 # https://www.linkedin.com/in/ravikumar-lubdhi/
 # https://github.com/ravikumarsl

Feature: Login Page Feature

@login
Scenario: Login page title
  Given user is on home page
  Then home page title should be "Home to India's Best Book Boxes| 99bookscart"
  When user clicks on login account
  When user gets the title of the page
  Then page title should be "Login"

@login
Scenario: Forgot Password link
  Given user is on login page
  Then forgot your password link should be displayed

@login
Scenario: Login with correct credentials
  Given user is on login page
  When user enters username "ravikumar.lubdhi@gmail.com"
  And user enters password "Tester@1234"
  And user clicks on Login button
  Then after login title of the page
