package demoTest.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demoTest.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents{

	WebDriver driver;

	/*@FindBy(css = ".totalRow button")
	WebElement checkoutEle;*/

	@FindBy(css = "tr td:nth-child(3)")
	private List<WebElement> productNames;
	
	@FindBy(css = ".table.table-bordered.table-hover.ng-star-inserted")
	private WebElement ordersTable;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public Boolean VerifyOrderDisplay(String productName) {
		waitForWebElementToAppear(ordersTable);
		Boolean match = productNames.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;

	}

}
