
@tag
Feature: Error Validation of for Ecommerce site
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Negative test
  	Given I landed on ecommerce page
    When Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed
    
    Examples: 
      | name  						| password 		| 
      | testJun@gmail.com | Test@1245		|
