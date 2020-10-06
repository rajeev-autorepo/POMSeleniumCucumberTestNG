package stepDefinitions;

import java.util.List;

import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AddTeriffPlans;
import pages.HomePage;
import pages.LoginPageClass;
import util.Singleton;
import util.TestBase;

public class AddTeriffPlansSteps extends TestBase {
	AddTeriffPlans addTeriff;
	LoginPageClass loginPage;
	HomePage homepage;
	
	@Given("^user opens the browser$")
	public void user_opens_the_browser() throws Throwable {
	 TestBase.initialization();  
	 loginPage = new LoginPageClass();
	 loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
	}

	@When("^click on left three bars icon$")
	public void click_on_left_three_bars_icon() throws Throwable {
		homepage = new HomePage();
		homepage.verifyTelecomPageTitle();
		addTeriff = new AddTeriffPlans();
		addTeriff.clickOnThreeBars();
				
	}

	@Then("^user click on Add Teriff plans menu item$")
	public void user_click_on_Add_Teriff_plans_menu_item() throws Throwable {
		addTeriff.clickOnAddTeriffPlanMenu();
		String terifplantitle = addTeriff.verifyAddTeriffPlansTitle();
		System.out.println("terif plan title is: "+terifplantitle);
		Assert.assertEquals(terifplantitle, prop.getProperty("addTeriffplantitle"));
	  
	}

	@Then("^Enter char value into monthly rental and validate error message$")
	public void enter_char_value_into_monthly_rental_and_validate_error_message() throws Throwable {
		addTeriff.enterMonthlyRental("rental");
		String errormessage = addTeriff.getErrorMessageOnMonthlyRental();
		System.out.println("Found error message on Add Teriff plan page is: "+errormessage);
		Assert.assertEquals(errormessage, prop.getProperty("expErroronMonthlyRental"));
	   
	}

	@Then("^enter number into monthly rental and char value into local free minutes and validate the error message$")
	public void enter_number_into_monthly_rental_and_char_value_into_local_free_minutes_and_validate_the_error_message() throws Throwable {
		addTeriff.enterMonthlyRentalvalid(1234);
		addTeriff.enterFreeLocalMinutes("free1");
		String error = addTeriff.getErrorMessageonFreeLocalMinutes();
		System.out.println("Found error message on free local minutes: "+error);
		Assert.assertEquals(error, prop.getProperty("expErroronMonthlyRental"));
	   
	}

	@Then("^enter alpha numeric value with special char into monthly rental and validate error message$")
	public void enter_alpha_numeric_value_with_special_char_into_monthly_rental_and_validate_error_message() throws Throwable {
		addTeriff.enterMonthlyRental(prop.getProperty("rentalalphanumeric"));
		String error = addTeriff.getErrorMessageOnMonthlyRental();
		Assert.assertEquals(error, prop.getProperty("error_on_spl_char"));
	   
	}

	@Then("^click on Reset button to validate it$")
	public void click_on_Reset_button_to_validate_it() throws Throwable {
		addTeriff.clickOnResetButton();
		String rentalattribute = addTeriff.getAttributeofMonthlyRental();
		System.out.println("attribute in monthly rental is: "+rentalattribute);
		Assert.assertEquals(rentalattribute, prop.getProperty("attribute_in_monthlyrental"));
	  
	}

	@Then("^enter valid numeric value in each fields and save and validate the success message$")
	public void enter_valid_numeric_value_in_each_fields_and_save_and_validate_the_success_message(DataTable addTeriffPlanDetails) throws Throwable {
		List<List<String>> validteriffData = addTeriffPlanDetails.raw();
		addTeriff.enterMonthlyRental(validteriffData.get(0).get(0));
		Singleton.getInstance().setFirstValueInGrid(validteriffData.get(0).get(0));
		addTeriff.enterFreeLocalMinutes(validteriffData.get(0).get(1));
		addTeriff.enterFreeInternationalMinutes(validteriffData.get(0).get(2));
		addTeriff.enterFreeSMSpack(validteriffData.get(0).get(3));
		addTeriff.enterLocalPerMinuteCharges(validteriffData.get(0).get(4));
		addTeriff.enterIntlPerMinuteCharges(validteriffData.get(0).get(5));
		addTeriff.enterSMSperCharges(validteriffData.get(0).get(6));
		Singleton.getInstance().setLastValueInGrid(validteriffData.get(0).get(6));
		addTeriff.clickOnSubmitButton();
		String successmsg = addTeriff.successMsg();
		Assert.assertEquals(successmsg, prop.getProperty("successMsgafteraddTeriff"));
		addTeriff.clickOnHomeButton();
		
	}
	
	@Then("^close the browser here$")
	public void close_the_browser_here() {
		driver.quit();
	}
	
	

}
