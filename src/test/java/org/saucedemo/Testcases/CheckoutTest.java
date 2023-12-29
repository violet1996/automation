package org.saucedemo.Testcases;

import org.saucedemo.AbstractComponent.AbstractComponent;
import org.saucedemo.pageObjects.CheckoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BasePage
{
	@Test
	public void TestCheckout()
	{
		CheckoutPage checkoutTest = new CheckoutPage(driver);

		// validate checkout information page
		String chckoutStinrg = checkoutTest.checkoutTitle().getText();
		String checkoutpage = "Checkout: Your Information";
		Assert.assertEquals(chckoutStinrg, checkoutpage);

		checkoutTest.firstName().sendKeys("sumit");
		checkoutTest.lastName().sendKeys("kumar");
		checkoutTest.postalCode().sendKeys("110096");

		checkoutTest.continueButton();

		String chckout = checkoutTest.checkoutOverview().getText();
		String checkoutOverView = "Checkout: Overview";
		Assert.assertEquals(chckout, checkoutOverView);

		String totalPriceText = checkoutTest.elementprice().getText();

		AbstractComponent abs = new AbstractComponent();

		if (abs.isTotalPriceValid(totalPriceText))
		{
			System.out.println("Total Price is in $xx.yy format!");
		} else
		{
			System.out.println("Total Price is not in the expected format: " + totalPriceText);
		}

		/*
		 * String regex = "[-+]?[0-9]*\\.?[0-9]+";
		 * 
		 * Pattern pattern = Pattern.compile(regex);
		 * 
		 * Matcher matcher = pattern.matcher(elemeneString);
		 * 
		 * while (matcher.find()) { String doubString=matcher.group(); double
		 * extractedDoubl=Double.parseDouble(doubString);
		 * 
		 * String extractedDouble=String.valueOf(extractedDoubl);
		 * if(extractedDouble.matches("\\b\\d{1,2}\\.\\d{2}\\b")) {
		 * System.out.println("total cost is in the format of$xx.xx"); }
		 * 
		 * }
		 */

	}
}
