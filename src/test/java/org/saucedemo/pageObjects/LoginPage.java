package org.saucedemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-name")
	WebElement userId;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginButton;
	
	public void setUserName(String uName) {
		userId.sendKeys(uName);
	}
	
	public void setPasswrod(String uPassword) {
		password.sendKeys(uPassword);
	}
	
	public void loginButton() {
		loginButton.click();
	}

	
}
