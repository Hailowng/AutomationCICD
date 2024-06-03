package demoTest.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import demoTest.PageObject.CartPage;
import demoTest.PageObject.CheckoutPage;
import demoTest.PageObject.ConfirmationPage;
import demoTest.PageObject.LandingPage;
import demoTest.PageObject.ProductCatalogue;
import demoTest.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImplementation extends BaseTest {
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
	
	@Given("I landed on ecommerce page")
	public void I_landed_on_ecommerce_page() throws IOException {
		landingPage = launchApplication();
	}

	@When("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String userName,String password) {
		 productCatalogue = landingPage.loginApplication(userName,password);	
	}
	
	@When ("I add the product {string} to the cart")
	public void I_add_the_product_to_the_cart(String productName) throws InterruptedException {
//		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	}
	@When ("checkout {string} and submit the order")
	public void checkout_and_submit_the_order(String productName) {
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		confirmationPage = checkoutPage.submitOrder();
	}
	
	@Then ("{string} message is displayed on the Confirmation Page")
	public void message_is_displayed_on_the_Confirmation_Page(String string) {
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.quit();
		
	}
	
	@Then ("{string} message is displayed") //"^\"([^\"]*)"
	public void message_is_displayed(String string) {
		Assert.assertEquals(string, landingPage.getErrorMessage());
		driver.quit();
	}
	
}
