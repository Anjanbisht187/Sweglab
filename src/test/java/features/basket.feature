@Reg
Feature: Basket functionality

Scenario: verify user is able to add the prpduct into the basket 
  When user enter valid username "standard_user" and password "secret_sauce" details
  And user click on login button
  And user click on add to cart button
  Then  validate cart count is "1"