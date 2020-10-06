package stepDefinitions;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.LoginPageClass;
import util.TestBase;

public class HomePageSteps extends TestBase {	
	LoginPageClass loginpage;
	HomePage homePage;
		
	@Given("^user open the browser$")
	public void user_open_the_browser() throws Throwable {
		TestBase.initialization();
	}
	
	@Then("^validate the login page title$")
	public void validate_the_login_page_title() {
		loginpage = new LoginPageClass();
		String actualTitle = loginpage.validateLoginTitle();
		System.out.println("Login page title is: "+actualTitle);
		Assert.assertEquals(actualTitle, prop.getProperty("loginpagetitle"));
		
	}

	@When("^user login into the system$")
	public void user_login_into_the_system() throws Throwable {
		homePage = loginpage.login(prop.getProperty("username1"), prop.getProperty("password1"));
		
	}

	@Then("^validate home page title$")
	public void validate_home_page_title() throws Throwable {
		String actual = homePage.verifyBankHomePageTitle();
		System.out.println("Bank home page title is: "+actual);
		Assert.assertEquals(actual, prop.getProperty("Bankhomepagetitle"));
	   
	}

	@Then("^validate telecom page title$")
	public void validate_telecom_page_title() throws Throwable {
		String actualTelecomPagetitle = homePage.verifyTelecomPageTitle();
		System.out.println("Telecom page title is: "+ actualTelecomPagetitle);
		Assert.assertEquals(actualTelecomPagetitle, prop.getProperty("telecompagetile"));
	   
	}
	
	@Then("^validate all the elements on home page$")
	public void validate_all_the_elements_on_home_page() {
		boolean actual = homePage.validateAllElementsOntheHomePage();
		System.out.println("all elements on the home page are displayed? :"+actual);
		Assert.assertTrue(actual);
		
	}

	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
		driver.close();
		driver.quit();
	   
	}
	
	
	
	
	
	

}
