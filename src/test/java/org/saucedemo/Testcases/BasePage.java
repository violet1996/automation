package org.saucedemo.Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BasePage
{

	public String BaseUrl = "https://www.saucedemo.com/";
	public String username = "standard_user";
	public String password = "secret_sauce";
	public static WebDriver driver;

	@BeforeTest
	public void setup()
	{

		WebDriverManager.firefoxdriver().setup();
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

	}

	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
