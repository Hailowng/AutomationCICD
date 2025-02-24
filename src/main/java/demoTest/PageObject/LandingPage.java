package demoTest.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demoTest.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{

		WebDriver driver;
		
		public LandingPage(WebDriver driver)
		{
			super(driver);
			//initialization
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}
			
		//WebElement userEmails = driver.findElement(By.id("userEmail"));
		//PageFactory
		
		@FindBy(id="userEmail")
		private WebElement userEmail;
		
		@FindBy(id="userPassword")
		private WebElement passwordEle;
		
		@FindBy(id="login")
		private WebElement submit;
		
		private @FindBy(css="[class*='flyInOut']")
		WebElement errorMessage;

		
		public ProductCatalogue loginApplication(String email,String password)
		{
			userEmail.sendKeys(email);
			passwordEle.sendKeys(password);
			submit.click();
			ProductCatalogue productCatalogue = new ProductCatalogue(driver);
			return productCatalogue;
			
			
		}
		
		public String getErrorMessage()
		{
			waitForWebElementToAppear(errorMessage);
			return errorMessage.getText();
		}
		
		public void goTo()
		{
			driver.get("https://rahulshettyacademy.com/client");
		}
}
