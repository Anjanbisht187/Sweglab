@Reg
Feature: Login functionality
@Smoke1
Scenario: login with valid credentials
    When userenter "standard_user" and password "secret_sauce" details
    #And userclick on login button
    Then validate Successful login
   

    
    
Scenario: login with invalid credentials    //data if change/step defination not change bc data regecs place  

    When user enter valid username "standard_not_user" and password "secret_not_sauce" details
   And user click on login button
  Then validate error message
   
   
Scenario: login with valid user name and invalid password  credentials
   When user enter valid username "standard_user" and password "secret_not_sauce" details
   And user click on login button
   Then validate error message
       
Scenario: login with invalid username and valid password credentials

    When user enter valid username "standard_not_user" and password "secret_sauce" details   
     And user click on login button   
      Then validate error message    
   Scenario: login with  blank username and blank password credentials

    When user enter valid username " " and password " " details
    And user click on login button
    Then validate error message
    
    