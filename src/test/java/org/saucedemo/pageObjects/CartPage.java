package org.saucedemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage
{
	
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement cartButton;
	
	
	
	@FindBy(xpath="//span[@class='title']")
	WebElement cartPageTitle;
	
	@FindBy(xpath="//button[@id='checkout']")
	WebElement checkOut;
	
	public WebElement cartButton() {
		return cartButton;
	}
	
	public WebElement cartPageTitle() {
		return cartPageTitle;
	}
	
	public void checkOut() {
		checkOut.click();
	}
	
	

}
