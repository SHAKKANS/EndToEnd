package abstractclass;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobjects.CartPage;

public class AbstractComponent {

	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(className="shopping_cart_link")
	WebElement cartPage;
	
	public CartPage goToCartPage() {
		cartPage.click();
		CartPage cartPage= new CartPage(driver);
		return cartPage;
			}
	
	public void waitforElementToAppear(List<WebElement> products) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));	
		wait.until(ExpectedConditions.visibilityOfAllElements(products));
	}
}


