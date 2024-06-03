
@tag
Feature: Purchase order from e-commerce website
  I want to use this template for my feature file


Background:

Given I landed on ecommerce page

  @tag2
  Scenario Outline: Positive test of submitting the order
    When Logged in with username <name> and password <password>
    When I add the product <productName> to the cart
   	And checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on the Confirmation Page

    Examples: 
      | name  						| password 			| productName  |
      | testJun@gmail.com | Test@12345		| ZARA COAT 3 |
      | hoshi@test.com		| Test@12345		| ADIDAS ORIGINAL   |
    
