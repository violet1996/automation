package org.test.automation;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class HomePage extends Base
{

	public void Login() throws InterruptedException {
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.id("login-button")).click();
		
		System.out.println(driver.getTitle());

		
		
		//3 dots
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		
		//about
		driver.findElement(By.cssSelector(".bm-item.menu-item:nth-child(2)")).click();
		
		//org.openqa.selenium.NoSuchElementException: Unable to locate element: .bm-item menu-item:nth-child(2)
		
	//	driver.quit();
		

		
		
		String currentUrl= driver.getCurrentUrl();
		String expectedUrl="https://saucelabs.com/";
		
		Assert.assertEquals(currentUrl, expectedUrl);
		driver.navigate().back();
		String productPageTitle="Products";
		
		WebElement productElement=driver.findElement(By.xpath("//span[@class='title']"));
		String string_product=productElement.getText();
		System.out.println(string_product);
		
		
		Assert.assertEquals(productPageTitle, string_product);
		
		List<WebElement> productList=driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		List<WebElement> AddtoCart=driver.findElements(By.xpath("//button[text()= 'Add to cart']"));
		
		int sizeOfProd=productList.size();
		
		double minPrice=Double.MIN_VALUE;
		int minIndex=0;
		
		WebElement maxPriceButton =null;
		
		for(int i=1;i<sizeOfProd;i++)
		{
		//	WebElement productPrice=driver.findElement(By.xpath("//div[@class='inventory_item_price']"));
			WebElement Price=productList.get(i);
			String price1=Price.getText();
			System.out.println(price1);
			
			double currentPrice=Double.parseDouble(price1.replaceAll("[^0-9.]", ""));
			
			if(currentPrice>minPrice)
			{
				minPrice=currentPrice;
				minIndex=i;
				
				 maxPriceButton=AddtoCart.get(i);
				
				
			}
		}
		
		maxPriceButton.click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		
	
		

		WebElement cartpage=driver.findElement(By.xpath("//span[@class='title']"));
		String string_cart=cartpage.getText();
		System.out.println(string_cart);
		String CartValue="Your Cart";
		
		
		Assert.assertEquals(string_cart, CartValue);
		
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		
		driver.findElement(By.id("first-name")).sendKeys("sumit");
		driver.findElement(By.id("last-name")).sendKeys("kumar");
		driver.findElement(By.id("postal-code")).sendKeys("110096");
	
		driver.findElement(By.id("continue")).click();
		
		WebElement checkout=driver.findElement(By.xpath("//span[@class='title']"));
		String chckoutStinrg=checkout.getText();
		String checkoutpage="Checkout: Overview";
		Assert.assertEquals(chckoutStinrg, checkoutpage);
		
		Thread.sleep(2000);
		WebElement elementprice=driver.findElement(By.xpath("//div[@class='inventory_item_price']"));
		String elemeneString= elementprice.getText();		
	
		
		//	double totalprice=Double.parseDouble(elemeneString.replaceAll("[^0-9.]", ""));
		String regex="[-+]?[0-9]*\\.?[0-9]+";
		
		Pattern pattern=Pattern.compile(regex);
		
		Matcher matcher=pattern.matcher(elemeneString);
		while (matcher.find())
		{
			String doubString=matcher.group();
			double extractedDoubl=Double.parseDouble(doubString);
			
			String extractedDouible=String.valueOf(extractedDoubl);
			if(extractedDouible.matches("\\b\\d{1,2}\\.\\d{2}\\b"))
			{
				System.out.println("total cost is in the format of$xx.xx");
			}
			
		}
		
		
	}
}
