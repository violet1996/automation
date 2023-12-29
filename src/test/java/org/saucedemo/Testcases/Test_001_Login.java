package org.saucedemo.Testcases;

import org.saucedemo.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_001_Login extends BasePage
{
	
	@Test
	public void LoginTest()
	{
		
		driver.get(BaseUrl);
	
		
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.setUserName(username);
		loginPage.setPasswrod(password);
		loginPage.loginButton();
		
		if (driver.getTitle().equals("Swag Labs"))
		{
			Assert.assertTrue(true);
			
		}
		else 
		{
			Assert.assertTrue(false);
			
		}
	}

}
