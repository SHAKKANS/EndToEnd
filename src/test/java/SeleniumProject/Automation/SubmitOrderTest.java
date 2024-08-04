package SeleniumProject.Automation;


import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.LandingPage;

public class SubmitOrderTest {
	
		public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String productName = "Sauce Labs Backpack";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//landing
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		//driver.findElement(By.id("user-name")).click();
		LandingPage landingpage = new LandingPage(driver);
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("input#login-button")).click();
		//product list
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(3000);
		List<WebElement> products = driver.findElements(By.className("inventory_item"));
		//WebElement prod = products.stream().filter(product->product.findElement(By.className("inventory_item_name")).getText().equals("Sauce Labs Bike Light")).findFirst().orElse(null);
		//prod.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		WebElement prod1 = products.stream().filter(product->product.findElement(By.className("inventory_item_name")).getText().equals("Sauce Labs Backpack")).findFirst().orElse(null);
		prod1.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.className("shopping_cart_link")).click();
		
		//cart page
		//String s = driver.findElement(By.id("inventory_item_name")).getText();
		//driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
		List<WebElement> cartProducts =(driver.findElements(By.cssSelector(".inventory_item_name")));
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue( match);
		driver.findElement(By.id("checkout")).click();
		
		//checkout page
		driver.findElement(By.id("first-name")).sendKeys("Shakkila");
		driver.findElement(By.id("last-name")).sendKeys("Ansari");
		driver.findElement(By.id("postal-code")).sendKeys("12345");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
		
		//confirmation Page
		String s1= driver.findElement(By.cssSelector("h2.complete-header")).getText();
		Assert.assertEquals(s1, "Thank you for your order!");
		driver.close();
		}
}

