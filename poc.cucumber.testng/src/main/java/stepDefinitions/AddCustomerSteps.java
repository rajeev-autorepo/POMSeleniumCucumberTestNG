package stepDefinitions;

import java.util.List;

import org.openqa.selenium.Alert;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.AddCustomer;
import pages.HomePage;
import pages.LoginPageClass;
import util.Singleton;
import util.TestBase;

public class AddCustomerSteps extends TestBase {	
	LoginPageClass loginPage;
	AddCustomer addCustomer;
	HomePage homePage;
	//TestBase testBase;
	
	@Given("^user logs into the system$")
	public void user_logs_into_the_system() throws Throwable {
		TestBase.initialization();
		loginPage = new LoginPageClass();
		loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
		
	}
	
	@Then("^user lands on Add Customer page$")
	public void user_lands_on_Add_Customer_page() {
		homePage = new HomePage();
		addCustomer = homePage.landOnAddCustomerPage();
		
	}
	
    @Then("^user select Pending option and invalid details and submit$")
    public void user_select_Pending_option_and_invalid_details_and_submit(DataTable addDetails) throws InterruptedException {
    	addCustomer.closeAds();
    	List<List<String>> invalidData = addDetails.raw();
    	addCustomer.selectPendingRadiobutton();
    	addCustomer.fillDetails(invalidData.get(0).get(0), invalidData.get(0).get(1), invalidData.get(0).get(2), invalidData.get(0).get(3), invalidData.get(0).get(4));
    	addCustomer.clickOnSubmit();
    	
    	
    }
    @Then("^dismiss the alert$")
    public void dismissTheAlert() throws InterruptedException {
    	Alert alert = driver.switchTo().alert();
    	alert.accept();
    	Thread.sleep(5000);
    }
    
    
    @Then("^user select Done option and valid details and submit$")
    public void user_select_Done_option_and_valid_details_and_submit(DataTable addDetails1) throws InterruptedException {
    	List<List<String>> invalidData1 = addDetails1.raw();
    	addCustomer.selectDoneRadiobutton();
    	addCustomer.fillDetails(invalidData1.get(0).get(0), invalidData1.get(0).get(1), invalidData1.get(0).get(2), invalidData1.get(0).get(3), invalidData1.get(0).get(4));
    	addCustomer.clickOnSubmit();
    	
    }
	
	@Then("^save the generated customer id$")
	public void save_the_generated_customer_id() throws Throwable {
		String actualcustomerid = addCustomer.getCustomerID();
		System.out.println(actualcustomerid);
		Singleton.getInstance().setCustomerID(actualcustomerid);
	}

	@Then("^close the opened browser$")
	public void close_the_opened_browser() throws Throwable {
		driver.close();
		driver.quit();
	    
	}

}
