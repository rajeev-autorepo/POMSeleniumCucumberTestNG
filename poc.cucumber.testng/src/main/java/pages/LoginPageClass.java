package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class LoginPageClass extends TestBase {
	
  // page objects on this page ********************************
	@FindBy(xpath = "//input[@name='uid']")
	WebElement username;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@name='btnLogin']")
	WebElement LoginButton;
	
	// page object created ****************************************
	
	
	//initialize page objects
	public LoginPageClass() {
		PageFactory.initElements(driver, this); 
	}
	
	
	public WebElement getUsername() {
		return username;
	}
	
	public WebElement getPassword() {
		return password;
	}
	
	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	// actions on this page
	public String validateLoginTitle(){
		return driver.getTitle();
	}
	
    public HomePage login(String uname, String pwd) {
       	getUsername().sendKeys(uname);
    	getPassword().sendKeys(pwd);
    	getLoginButton().click();
     	
    	return new HomePage();
    }
}
