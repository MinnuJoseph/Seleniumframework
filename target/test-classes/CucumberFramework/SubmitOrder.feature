
@tag
Feature: Submit the order
  I want to use this template for my feature file
Background:
  Given Landed on Ecommercewebsite
  
  @Regression
  Scenario Outline: Submit the order in the Ecommerce website
    Given Logged in with <username> and <password>
    When Adding the <productname> to cart
    And Checkout <productname> and submit the order
    Then verify confirmation message displayed

    Examples: 
      | username  | password | productname  |
      | anshika@gmail.com |     Iamking@000 | ZARA COAT 3 |
     
Scenario Outline: Error Validating
Given Landed on Ecommercewebsite 
When Logged in with <username> and <password>
Then Verify "Incorrect email or password." is displayed

Examples: 
      | username  | password |
      | anshika@gmail.com |     Iamki000 | 