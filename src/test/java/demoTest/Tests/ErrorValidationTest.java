package demoTest.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import demoTest.PageObject.CartPage;
import demoTest.PageObject.ProductCatalogue;
import demoTest.TestComponents.BaseTest;


public class ErrorValidationTest extends BaseTest {

	@Test(groups= {"errorHandling"})
	public void LoginErrorValidation() throws IOException, InterruptedException {

		landingPage.loginApplication("testJun@gmail.com", "Test@1345");
		System.out.println(landingPage.getErrorMessage());
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	
	}
	@Test //(retryAnalyzer=demoTest.TestComponents.Retry.class)
	public void ProductErrorValidation() throws IOException, InterruptedException {
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("testJun@gmail.com", "Test@12345");
		//List<WebElement> products=productCatalogue.getProductList();
		productCatalogue.getProductByName(productName);
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
	}
}
