package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import util.TestBase;

public class HomePage extends TestBase {
	    // create page objects ***************************************
		// Page Factory - (Object Repository)
		@FindBy(linkText = "Telecom Project")
		WebElement TelecomMenu;
		
		@FindBy(linkText = "Bank Project")
		WebElement BankProjectMenu;
		
		@FindBy(xpath = "//span[@id='header']//a[1]")
		WebElement HamburgerIntoLeftMenu;
		
		@FindBy(linkText = "Home")
		WebElement HomeLinkIntoMenu;
		
		@FindBy(linkText = "Add Customer")
		WebElement AddCustomerLinkintoMenu;
		
		@FindBy(linkText = "Add Tariff Plan")
		WebElement AddTeriffPlansLinkintoMenu;
		
		@FindBy(linkText = "Add Tariff Plan to Customer")
		WebElement AddTeriffPlantoCustomerLinkintoMenu;
		
		@FindBy(linkText = "Pay Billing")
		WebElement PayBillingLinkintoMenu;
		
		//************************************************************
	
   // initialize page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	

	public String verifyBankHomePageTitle() {
		return driver.getTitle();
	}
	
	public String verifyTelecomPageTitle() {
		TelecomMenu.click();
		return driver.getTitle();
	}
	
	public boolean validateAllElementsOntheHomePage() {
		boolean b = false; 
		
		if( AddCustomerLinkintoMenu.isDisplayed() && AddTeriffPlansLinkintoMenu.isDisplayed()
			&& AddTeriffPlantoCustomerLinkintoMenu.isDisplayed() && PayBillingLinkintoMenu.isDisplayed()) {
			
			b= true;
	
		} else {System.out.println("some element is missing on home page");}
		
		return b;
	}
	
	public AddCustomer landOnAddCustomerPage() {
		TelecomMenu.click();
		AddCustomerLinkintoMenu.click();
		return new AddCustomer();
	}
	
	public void clickOnThreeBars() {
		HamburgerIntoLeftMenu.click();
	}
	
	public void clickOnTelecomMenu() {
		TelecomMenu.click();
	}
	
}