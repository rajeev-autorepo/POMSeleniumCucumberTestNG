package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AddCustomer;
import pages.AddTeriffPlanToCustomer;
import pages.AddTeriffPlans;
import pages.HomePage;
import pages.LoginPageClass;
import util.Singleton;
import util.TestBase;

public class AddTeriffPlantoCustomerSteps extends TestBase {
	LoginPageClass loginPage;
	HomePage homepage;	
	AddTeriffPlans addTeriffPlan;
	AddTeriffPlanToCustomer addTPtoCustomer;
	AddTeriffPlansSteps addTPSteps;
	AddCustomerSteps addCustSteps;
	AddCustomer addCustomer;
	
	@Given("^user opens up the browser and login$")
	public void user_opens_up_the_browser_and_login() throws Throwable {
	TestBase.initialization();  
	loginPage = new LoginPageClass();
	loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));	
		   
	}

	@When("^click on left three bar icon$")
	public void click_on_left_three_bar_icon() throws Throwable {
		
		  homepage = new HomePage();
		  homepage.clickOnTelecomMenu();
		//  homepage.clickOnThreeBars();
		 
	}

	@Then("^user click on Add Teriff Plan to Customer menu item$")
	public void user_click_on_Add_Teriff_Plan_to_Customer_menu_item() throws Throwable {
		addTPtoCustomer = new AddTeriffPlanToCustomer();
		addTPtoCustomer.clickOnAddTerifPlantoCustomerMenuItem();
		String title = addTPtoCustomer.verifyAddTeriffPlantoCustomerTitle();
		System.out.println("title of add teriff plan to customer page is: "+ title);
	    
	}

	@Then("^Enter incorrect customer id and validate error message$")
	public void enter_incorrect_customer_id_and_validate_error_message() throws Throwable {
		addTPtoCustomer.enterCustomerID(prop.getProperty("incorrectCustomerID"));
		addTPtoCustomer.clickOnSubmitButton();
		String error = addTPtoCustomer.errorMessageOnInvalidCustomerID();
		System.out.println("error msg on incorrect customer id is: "+ error );
		Assert.assertEquals(error, prop.getProperty("errorMsgonInvalidCustId"));
		addTPtoCustomer.clickOnSubmitButtonAfterErrorMsg();
	   
	}

	@Then("^enter correct customer id and validate the page title$")
	public void enter_correct_customer_id_and_validate_the_page_title() throws Throwable {
		System.out.println("Latest customerid is: "+Singleton.getInstance().getCustomerID());
		addTPtoCustomer.enterCustomerID(Singleton.getInstance().getCustomerID());
		addTPtoCustomer.clickOnSubmitButton();
		String title = addTPtoCustomer.verifyAddTeriffPlantoCustomerTitle();
		Assert.assertEquals(title, prop.getProperty("addTPtoCustomerPageTitle"));
	    
	}

	@Then("^verify first and last entered value in the grid$")
	public void verify_first_and_last_entered_value_in_the_grid() throws Throwable {
		//addTPSteps = new AddTeriffPlansSteps();
		String expFval = Singleton.getInstance().getFirstValueInGrid();
		System.out.println("exp fvalue is coming from singlton: "+expFval);
		String actualFval = addTPtoCustomer.firstValueInGrid();
		System.out.println("actual fvalue on page is: "+actualFval);
		Assert.assertEquals(actualFval, expFval);
		String expLval = Singleton.getInstance().getLastValueInGrid();
		System.out.println("exp lvalue is coming from singlton: "+expLval);
		String actualLval = addTPtoCustomer.lastValueInGrid();
		System.out.println("actual lvalue on page is: "+actualLval);
		Assert.assertEquals(actualLval, expLval);
		
		
	    
	}

	@Then("^select the radio button and click on add teriff plan to customer button$")
	public void select_the_radio_button_and_click_on_add_teriff_plan_to_customer_button() throws Throwable {
		addCustomer = new AddCustomer();
		addCustomer.closeAds();
		addTPtoCustomer.clickOnAddTeriffPlantoCustomerButtonAfterRB();
			  
	}

	@Then("^verify the success message$")
	public void verify_the_success_message() throws Throwable {
	    
		Assert.assertEquals(addTPtoCustomer.validateSuccessMsg(), prop.getProperty("successMsgAssignTP"));
		
	  
	}

	@Then("^close the current browser$")
	public void close_the_current_browser() throws Throwable {
		driver.quit();
	   
	}

}
