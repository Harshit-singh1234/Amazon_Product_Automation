package com.amazon.startup;

import com.amazon.driver.Driver;
import com.amazon.page.CartPage;
import com.amazon.page.ProductPage;
//import com.amazon.report.ReportListener;
import com.amazon.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import static com.amazon.driver.DriverManager.*;
import com.amazon.page.DashboaedPage;

import static java.util.Objects.nonNull;

public abstract class BaseTest {

	protected static WebDriver driver;
	protected DashboaedPage dashBoardpage;
	protected ProductPage productPage;
	protected CartPage cartPage;
	

	public static WebDriver getDriver() {
		return driver;
	}


	@BeforeMethod
	public void preCondition() {
		driver = new Driver().createInstance();
		driver.manage().window().maximize();
		driver.get(PropertyLoader.returnConfigValue("url.base"));
		dashBoardpage = new DashboaedPage(driver);
		productPage = new ProductPage(driver);
		cartPage = new CartPage(driver);
	}

	@AfterMethod
	public void tearDown() {
		if (nonNull(getWebDriver())) {
			getWebDriver().quit();
			unLoadWebDriver();
		}
	}
}