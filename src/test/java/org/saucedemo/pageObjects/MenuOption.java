package org.saucedemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuOption
{

	WebDriver driver;
	
	public MenuOption(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="react-burger-menu-btn")
	WebElement menuButton;
	
	
	@FindBy(id="about_sidebar_link")
	WebElement aboutButton;
	
	@FindBy(xpath ="//span[@class='title']")
	WebElement title;
	
	public void menuButton() {
		menuButton.click();
	}
	
	public void aboutButton() {
		aboutButton.click();
	}
	
	public String title() {
		return title.getText();
	}
	
}
