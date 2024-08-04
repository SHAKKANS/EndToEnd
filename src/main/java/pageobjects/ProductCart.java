package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractclass.AbstractComponent;

public class ProductCart extends AbstractComponent {

	WebDriver driver;

	public ProductCart(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	// PageFactory
	@FindBy(className = "inventory_item")
		List<WebElement> products;
	
	By addToCart = By.id("add-to-cart-sauce-labs-backpack");
	
		
	public List<WebElement> getProductList() {
		waitforElementToAppear(products);
		return products;
	}
	
	public WebElement getProductByName1(String productName1) {
		WebElement prod = getProductList().stream().filter(product1->product1.findElement(By.className("inventory_item_name")).getText().equals(productName1)).findFirst().orElse(null);
				return prod;
	}
		
	public WebElement addProduct1ToCart(String productName1) {
		WebElement prod=getProductByName1(productName1);
		prod.findElement(addToCart).click();
		return prod;
			}
}
