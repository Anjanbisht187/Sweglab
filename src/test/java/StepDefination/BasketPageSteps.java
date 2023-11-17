package StepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.Basket;

public class BasketPageSteps {
	
	Basket basket = new Basket();
	 @And("user click on add to cart button")
	 public void user_click_on_add_to_cart_button() {
		 
	basket.clickOnAddToCart();	 
		 
	 }
	  @Then("validate cart count is {string}")                    //data pass =stepdefination =regecs=arg
		  
		public void validate_cart_count(String count) {
		 basket.validateCartCount(count); 
	  }  
		  
	  }


