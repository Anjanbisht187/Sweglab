package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Base {
    public static  WebDriver driver;
	public static Properties prop;
	static {

		FileInputStream file;
		try {
			file = new FileInputStream(
					System.getProperty("user.dir")+"/src/test/java/resources/envir.properties");
			prop = new Properties();
			prop.load(file);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
   @Before
	public void setup() {

		String browsername = prop.getProperty("browser");  //switch case break
		if (browsername.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equals("ff")) {

			driver = new FirefoxDriver();
		} else if (browsername.equals("edge")) {

			driver = new EdgeDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

public void selectValueFromDropdown( WebElement ele ,String type, String value) {
Select s = new Select(ele);
switch(type) {

case "index":
	s.deselectByIndex(Integer.parseInt(value));
	break;
case "visible text" :
	s.selectByVisibleText(value);
	break;
case "value" :
   s.selectByValue(value);
   break;
}
}

public void selectBootStrapDropDown(List<WebElement> list, String value) {
	
	for(WebElement ele : list) {
		
	
		String actualvalue = ele.getText();
		if (actualvalue.equals(value)) {
			
			ele.click();
			break;
		}
	}
}	
	
public void mouseHover(WebElement ele) {
	
	Actions a = new Actions(driver);
a.moveToElement(ele).build().perform();
}

public void  waits(int value) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(value));
}	


public void handleAlertPopUp(String type) {
	Alert a = driver.switchTo().alert();
	switch(type) {
	case "OK":
	a.accept();
	break;
	case "cancel":
	a.dismiss();
	break;
	case "type":
	a.sendKeys("");
	break;
	case "textHighlight":
	 String s=a.getText();
	break;
	}
		
}
		
public void waitForExpectedElement( WebElement ele ,long wait) {
	
WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds( wait));
 w.until(ExpectedConditions.visibilityOf(ele));	
}


public void waitForElementToBeClickable( WebElement ele ,long wait) {
	
WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds( wait));
 w.until(ExpectedConditions.elementToBeClickable(ele));	
}

public void clickOnWebElement(WebElement ele ) {
waitForElementToBeClickable(ele, 0);
try{ele.click();		
}catch(Exception e) {
	waitForElementToBeClickable(ele, 0);
	
	executorClickonElement(ele);
}
}

public void executorClickonElement(WebElement ele)
{ JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0],scrollIntoView(true);", ele);
js.executeScript("argument[0].click();", ele);

}

 public void valdateText(WebElement ele , String expectedValue) {
	 
	String actualValue= ele.getText();
    Assert.assertEquals(expectedValue, actualValue);
 }
 
 

public void switchFrame( String value,String type) {  //webElement find 
	switch(type) {
	case "framename":
	driver.switchTo().frame(value);
	break;
	case "index":
		driver.switchTo().frame(Integer.parseInt(value));
	break;
	}
}

public void switchWindow(String title) {
	
	 Set<String> allWindows = driver.getWindowHandles();
	 for(String windowid:allWindows){
		 driver.switchTo().window(windowid);
		 if(driver.getTitle().contains(title)) {
			 break;
		 }	 		 
	 }
	}

public void clickOnCheckbox(WebElement ele) {
	
	if (!ele.isSelected()) {                              //isSelected return=boolean
	
	//ele.click();
		
		clickOnWebElement(ele);}
}
@After
public void tearDown(Scenario s) {                     //predclass in cucum
	if( s.isFailed()) {
	
	TakesScreenshot ts = (TakesScreenshot)driver;
	 File capturedScr=ts.getScreenshotAs(OutputType.FILE);
	 try {
		// FileHandler.copy(capturedScr, new File("Screenshots/test.png"));
		FileHandler.copy(capturedScr, new File ("Screenshots/ "+s.getName()+".png"));         //class
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}
	driver.quit();
}





	/*
	 * public void test() {
	 * 
	 * webElement ele = driver.findElement(""); selectValueFromDropdown( "country",
	 * "index", "India");
	 * 
	 * }/*
	 * 
	 * }
	 * 
	 
	 * 
	 * /* public void selectValueFromDropdown(WebElement ele, String value ) {
	 * 
	 * Select s = new Select(ele); s.selectByVisibleText( value); }
	 * 
	 * public void selectValueFromDropdown1(WebElement ele, int value ) {
	 * 
	 * Select s = new Select(ele); s.selectByIndex( value); }
	 * 
	 * public void selectValueFromDropdown2(WebElement ele, String value ) {
	 * 
	 * Select s = new Select(ele); s.selectByValue( value); }
	 */

}
