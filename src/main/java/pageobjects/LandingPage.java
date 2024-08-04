package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractclass.AbstractComponent;

public class LandingPage extends AbstractComponent{

	
		WebDriver driver;
		
	
		public LandingPage(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
			
		}

		//WebElement userEmail = driver.findElement(By.id("user-name"));
		//WebElement userPassword= driver.findElement(By.id("password"));
		//driver.findElement(By.cssSelector("input#login-button")).click();
		//PageFactory
		@FindBy(id="user-name")
		WebElement userEmail;
		
		@FindBy(id="password")
		WebElement userPassword;
		
		@FindBy(css="input#login-button")
		WebElement submit ;
		
		public ProductCart loginApplication(String email,String password) {
			userEmail.sendKeys(email);
			userPassword.sendKeys(password);
			submit.click();
			ProductCart productCart = new  ProductCart(driver);
			return productCart;
		}
		public void goTo() {
			driver.get("https://www.saucedemo.com/");
			
		}
		
	}

