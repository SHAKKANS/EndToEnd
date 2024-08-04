package SeleniumProject.Automation;


import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.CartPage;
import pageobjects.CheckOut11Page;
import pageobjects.ConfirmOrder;
import pageobjects.LandingPage;
import pageobjects.ProductCart;

public class SubmitOrderTestcopy  {
	
		public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String productName1 = "Sauce Labs Backpack";

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		//Login Application
		LandingPage landingpage = new LandingPage(driver);
		landingpage.goTo();
		ProductCart productCart = landingpage.loginApplication("standard_user","secret_sauce");
		
		//ProductPage
		List<WebElement> products = productCart.getProductList();
		productCart.addProduct1ToCart(productName1);
		CartPage cartPage=productCart.goToCartPage();
		
		//CartPage
		Boolean match = cartPage.verifyCartProduct(productName1);
		Assert.assertTrue(match);
		CheckOut11Page checkout11Page = cartPage.goToCheckOut();
	
		//Check out Page
		ConfirmOrder confirmorder=checkout11Page.ProvidePersonalInfo();
		
		//Confirm Order
		Assert.assertEquals(confirmorder.ConfirmMsg(), "Thank you for your order!");
	    driver.close();
		}
}

