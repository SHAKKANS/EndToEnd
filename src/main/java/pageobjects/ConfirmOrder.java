package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstractclass.AbstractComponent;

public class ConfirmOrder extends AbstractComponent{

	
		WebDriver driver;
		
	
		public ConfirmOrder(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}
		//PageFactory
		@FindBy(css="h2.complete-header")
		WebElement Confirmmsg ;
		
		public String ConfirmMsg() {
			String s1=Confirmmsg.getText();
			return s1;
		
	}
//		String s1= driver.findElement(By.cssSelector("h2.complete-header")).getText();
//		Assert.assertEquals(s1, "Thank you for your order!");
		
//		driver.findElement(By.id("first-name")).sendKeys("Shakkila");
//		driver.findElement(By.id("last-name")).sendKeys("Ansari");
//		driver.findElement(By.id("postal-code")).sendKeys("12345");
//		driver.findElement(By.id("continue")).click();
}//		driver.findElement(By.id("finish")).click();

