package org.saucedemo.Testcases;

import org.saucedemo.pageObjects.MenuOption;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuTest extends BasePage
{


	@Test
	public void menuTest()
	{
		MenuOption option=new MenuOption(driver);
		
		option.menuButton();
		
		option.aboutButton();
		

		String currentUrl= driver.getCurrentUrl();
		String expectedUrl="https://saucelabs.com/";
		
		Assert.assertEquals(currentUrl, expectedUrl);
		driver.navigate().back();
		
		String productPageTitle="Products";
		String productElement = option.title();
		Assert.assertEquals(productPageTitle, productElement);
	}
}
