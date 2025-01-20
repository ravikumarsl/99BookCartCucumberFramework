 # @author Ravikumar Lubdhi
 # https://www.linkedin.com/in/ravikumar-lubdhi/
 # https://github.com/ravikumarsl

Feature: Search Page Feature

Background:
  Given user is logged into the application

@search
Scenario: Search page title
	Given user clicks the search option
  Given user is on Search page
  When title of the page

@search
Scenario: Search Books And Add to Cart
  Given user is on Search page
  When user searches books "The Railway Man"
  Then the search results should show books related to "The Railway Man"
  When click on product
  When add to cart
  When product added to cart
  When open cart
  Then verify first product
  Then price of first product "149"
  Given user clicks the search option
  Given user is on Search page
	When click on non fiction
	When click on genres
	When add second product to cart
	When add third product to cart
	When add fourth product to cart
	When add fifth product to cart
	When open cart
	Then verify second product
	Then price of second product "149"
	Then price of third product "219"
	Then price of fourth product "149"
	Then price of fifth product "99"
	Then total price of products "765"
	
	
	
	