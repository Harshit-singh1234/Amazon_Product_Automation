package com.amazon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {

	private WebDriver driver;

	public CartPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
	private WebElement btnProceedToCheckout;

	public void verifyCartAndCheckout() {
		try {
			By priceInAddToCartPage = By.xpath(".//div[contains(@class,'item-price')]//span[contains(@class,'price')]");
			String priceInCart = driver.findElement(priceInAddToCartPage).getAttribute("innerText").trim();
			System.out.println("Actual product price is: " + priceInCart);
			Assert.assertTrue(priceInCart.contains(DashboaedPage.productPrice), "product price not matched");
			btnProceedToCheckout.click();
		}catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
