@Reg
Feature: checkout functionality
@Smoke
Scenario: ckeckout with valid firstname lastname and postalcode

    When user enter valid username "standard_user" and password "secret_sauce" details
    And user click on login button
      And user click on addtocart button
  Then  validate cart count is "1" 
   