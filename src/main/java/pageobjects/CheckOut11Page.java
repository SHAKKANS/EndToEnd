package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstractclass.AbstractComponent;

public class CheckOut11Page extends AbstractComponent{

	
		WebDriver driver;
		
	
		public CheckOut11Page(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}

		//PageFactory
		@FindBy(id="first-name")
		WebElement firstName ;
		
		@FindBy(id="last-name")
		WebElement lastName ;
		
		@FindBy(id="postal-code")
		WebElement postalCode;
		
		@FindBy(id="continue")
		WebElement submit;
		
		@FindBy(id="finish")
		WebElement finish;
		
		
		
		public ConfirmOrder ProvidePersonalInfo() {
			firstName.sendKeys("SH");
			lastName.sendKeys("AN");
			postalCode.sendKeys("12345");
			submit.click();
			finish.click();
			ConfirmOrder confirmorder =  new ConfirmOrder(driver);
			return confirmorder;
	}
		
//		driver.findElement(By.id("first-name")).sendKeys("Shakkila");
//		driver.findElement(By.id("last-name")).sendKeys("Ansari");
//		driver.findElement(By.id("postal-code")).sendKeys("12345");
//		driver.findElement(By.id("continue")).click();
}//		driver.findElement(By.id("finish")).click();

