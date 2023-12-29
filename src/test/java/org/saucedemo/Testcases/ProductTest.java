package org.saucedemo.Testcases;

import org.openqa.selenium.WebElement;
import org.saucedemo.pageObjects.ProductPage;
import org.testng.annotations.Test;

public class ProductTest extends BasePage
{
	@Test
	public void TestProduct() throws InterruptedException
	{
		ProductPage productPage = new ProductPage(driver);

		int size = productPage.productList().size();

		double maxPrice = Double.MIN_VALUE;

		WebElement element = null;

		for (int i = 0; i < size; i++)
		{
			WebElement productPrices = productPage.productList().get(i);
			String price = productPrices.getText();
			double originalPrice = Double.parseDouble(price.replaceAll("[^0-9.]", ""));

			if (originalPrice > maxPrice)
			{
				maxPrice = originalPrice;
				element = productPage.addToCart().get(i);
			}
		}

		element.click();

	}

}
