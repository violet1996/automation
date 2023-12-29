package org.saucedemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage
{
	

	WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first-name")
	WebElement firstName;
	
	@FindBy(id="last-name")
	WebElement lastName;
	
	@FindBy(id="postal-code")
	WebElement postalCode;
	
	@FindBy(id="continue")
	WebElement continueButton;
	
	@FindBy(xpath="//span[@class='title']")
	WebElement checkoutTitle;
	
	@FindBy(xpath="//div[@class='inventory_item_price']")
	WebElement elementprice;
	
	@FindBy(xpath="//span[@class='title']")
	WebElement checkoutOverview;
		
	public WebElement firstName() {
		return firstName;
	}
	
	public WebElement lastName() {
		return lastName;
	}
	
	public WebElement postalCode() {
		return postalCode;
	}
	
	public void continueButton() {
		continueButton.click();
	}
	
	public WebElement checkoutTitle() {
		return checkoutTitle;
	}
	
	public WebElement elementprice() {
		return elementprice;
	}
	
	public WebElement checkoutOverview() {
		return checkoutOverview;
	}
	
	

}
