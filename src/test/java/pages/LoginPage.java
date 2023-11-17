package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.Base;

public class LoginPage extends Base {
	public void user_enter_valid_username_and_password_details(String username, String pass) {
		
	  // WebElement userName =driver.findElement(By.xpath("//input[@id=\"user-name\"]"));
	   
	   WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
	
		userName.sendKeys(username);
		waits(5);
		
	 WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
			
			password.sendKeys(pass);
			waits(5);
	}
	public void user_click_on_login_button() {
		WebElement login=driver.findElement(By.cssSelector("input#login-button"));
		login.click();
		waits(10);
	}
	public void validte_error_message() {
		WebElement errorMessage=driver.findElement(By.xpath( "//h3[@data-test=\"error\"]"));
		Assert.assertTrue(errorMessage.isDisplayed());
		
	}
	
}
 