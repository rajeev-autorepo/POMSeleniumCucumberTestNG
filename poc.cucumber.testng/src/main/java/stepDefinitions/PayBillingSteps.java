package stepDefinitions;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AddTeriffPlanToCustomer;
import pages.HomePage;
import pages.LoginPageClass;
import pages.PayBilling;
import util.TestBase;

public class PayBillingSteps extends TestBase {
	LoginPageClass loginPage;
	HomePage homePage;
	PayBilling payBilling;
	AddTeriffPlanToCustomer addTPtoCust;
	
	@Given("^user launches the browser and login$")
	public void user_launches_the_browser_and_login() throws Throwable {
		TestBase.initialization();  
		loginPage = new LoginPageClass();
		loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));	   
	}

	@When("^click on Telecom menu and pay billing link$")
	public void click_on_Telecom_menu_and_pay_billing_link() throws Throwable {
	//	homePage.verifyTelecomPageTitle();
		
		payBilling = new PayBilling();
		payBilling.clickOnTelecomMenu();
		payBilling.clickOnPayBillingLink();
		String paybillingpagetitle = payBilling.verifyPayBillingTitle();
		Assert.assertEquals(paybillingpagetitle, prop.getProperty("payBillingPageTitle"));
	   
	}

	@Then("^enter incorrect customer id and validate error message$")
	public void enter_incorrect_customer_id_and_validate_error_message() throws Throwable {
		addTPtoCust = new AddTeriffPlanToCustomer();
		addTPtoCust.enterCustomerID(prop.getProperty("incorrectCustIDforPayBilling"));
		addTPtoCust.clickOnSubmitButton();
		String errormsg = payBilling.errorMessageonIncorrectCustomerID();
		Assert.assertEquals(errormsg, prop.getProperty("errorMsgPayBilling"));
		payBilling.clickOnPayBillingLinkAfterErrorMsg();
	   
	}

	@Then("^enter correct customer id and validate the page$")
	public void enter_correct_customer_id_and_validate_the_page() throws Throwable {
		addTPtoCust.enterCustomerID(prop.getProperty("correctCustomerID"));
		addTPtoCust.clickOnSubmitButton();
		boolean headervalue = payBilling.visibilityOfHeader();
		Assert.assertTrue(headervalue);
	    
	}

	@Then("^Verify that Local Minutes, International Minutes and SMS Pack are visible on the page$")
	public void verify_that_Local_Minutes_International_Minutes_and_SMS_Pack_are_visible_on_the_page() throws Throwable {
		String localminutes = payBilling.getLocalMinutesValue();
		Assert.assertEquals(localminutes, prop.getProperty("localMinute"));
		String intlmin = payBilling.getIntlMinutesValue();
		Assert.assertEquals(intlmin, prop.getProperty("intlMinute"));
		String sms = payBilling.getSMSpackValue();
		Assert.assertEquals(sms, prop.getProperty("smsPack"));
	}

	@Then("^Verify that Tariff Plan Amout, Usage Charges and Total Bill is displaying$")
	public void verify_that_Tariff_Plan_Amout_Usage_Charges_and_Total_Bill_is_displaying() throws Throwable {
		String terifamount = payBilling.getTeriffplanAmountValue();
		Assert.assertEquals(terifamount, "500");
		String usagecharge = payBilling.getUsageChargesValue();
		Assert.assertEquals(usagecharge, "250");
		String totalBill = payBilling.getTotalBillValue();
		Assert.assertEquals(totalBill, "750");
	  
	}

	@Then("^close the chrome browser$")
	public void close_the_chrome_browser() throws Throwable {
		driver.quit();
	    
	}

}
