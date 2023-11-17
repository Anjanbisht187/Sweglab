package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.Base;

public class Basket extends Base{
	public void clickOnAddToCart(String labs) {
  WebElement addToCartbtn = driver.findElement(By.cssSelector( " button.add-to-cart-sauce-labs-backpack" ));
    clickOnWebElement(addToCartbtn) ;
	}

public void validateCartCount(String count) {
	
	WebElement  cartCount=driver.findElement(By.cssSelector(""));
     String cartValue = cartCount.getText();
     Assert.assertEquals(count, cartValue);
}  
  
}
