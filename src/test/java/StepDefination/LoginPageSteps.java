package StepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginPageSteps {                                                     //two rejeks//acc.that two cards
	LoginPage login =  new LoginPage();
	
	@When("userenter {string} and password {string} details")
	public void userenter_and_password_details(String username, String pass) {
	   login.user_enter_valid_username_and_password_details(username, pass);
	}
	@When("userclick on login button")
	public void user_click_on_login_button() {
	    login.user_click_on_login_button();
	}
	@Then("validate Successful login")
	public void validate_successful_login() {
	    login.validte_error_message();
	}
	
	
	   
	}

