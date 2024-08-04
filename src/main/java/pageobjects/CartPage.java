package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstractclass.AbstractComponent;

public class CartPage extends AbstractComponent{

	
		WebDriver driver;
		
	
		public CartPage(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		//PageFactory
		@FindBy(css=".inventory_item_name")
		List<WebElement> cartProducts;
		
		@FindBy(id="checkout")
		WebElement CheckOut;
				
		public Boolean verifyCartProduct(String productName1) {
			
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName1));
		return match;
		}
		
		public CheckOut11Page goToCheckOut() {
		CheckOut.click();
		CheckOut11Page checkOut11Page=new CheckOut11Page(driver);
		return checkOut11Page;
		
						
	}
}

