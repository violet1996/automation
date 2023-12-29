package org.saucedemo.AbstractComponent;

public class AbstractComponent
{


	public boolean isTotalPriceValid(String totalPriceText1) {
        // Regular expression with optional decimal places
        final String regex = "^\\$(\\d{1,3})(\\.\\d{2})?$";
        return totalPriceText1.matches(regex);
    }
}
