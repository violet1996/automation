package org.saucedemo.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage
{

	WebDriver driver;

	public ProductPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='inventory_item_price']")
	List<WebElement> productList;

	@FindBy(xpath = "//button[text()= 'Add to cart']")
	List<WebElement> addToCart;

	public List<WebElement> productList()
	{
		return productList;
	}

	public List<WebElement> addToCart()
	{
		return addToCart;
	}

}
