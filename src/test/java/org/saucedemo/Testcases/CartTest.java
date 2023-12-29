package org.saucedemo.Testcases;

import org.saucedemo.pageObjects.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BasePage
{
	@Test
	public void TestCart()
	{
		CartPage cartpage=new CartPage(driver);
		cartpage.cartButton().click();
		String string_cart=cartpage.cartPageTitle().getText();
		//System.out.println(string_cart);
		String CartValue="Your Cart";
		
		
		Assert.assertEquals(string_cart, CartValue);
		//System.out.println(CartValue);
		
		
		
		cartpage.checkOut();
		
		
	}
}
