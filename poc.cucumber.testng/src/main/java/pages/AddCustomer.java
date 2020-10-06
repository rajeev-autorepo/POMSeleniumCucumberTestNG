package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class AddCustomer extends TestBase {
	 // create page objects ***************************************///
	// Page Factory - OR (Object Repository)
	
	@FindBy(xpath = "//label[contains(text(),'Pending')]")
	WebElement RadioButtonPending;
	
	@FindBy(xpath = "//label[contains(text(),'Done')]")
	WebElement RadioButtonDone;
	
	@FindBy(id = "fname")
	WebElement TextBoxFirstName;
	
	@FindBy(id = "lname")
	WebElement TextBoxLastName;
	
	@FindBy(id = "email")
	WebElement TextBoxEmailId;
	
	@FindBy(id = "message")
	WebElement TextBoxAddress;
	
	@FindBy(xpath = "//label[@id='message3')]")
	WebElement TextAreaMessage1;
	
	@FindBy(tagName = "textarea")
	WebElement TextAreaMessage2;
	
	@FindBy(xpath = "//input[@id='telephoneno']")
	WebElement TextBoxMobileNumber;
	
	@FindBy(name = "submit")
	WebElement SubmitButton;
	
	@FindBy(xpath = "//div[@id='closeBtn']")
	WebElement ifrmaeCloseButton;
	
	@FindBy(css = "body.subpage:nth-child(5) section.wrapper:nth-child(7) div.inner div.table-wrapper table.alt.access tbody:nth-child(1) tr:nth-child(1) td:nth-child(2) > h3:nth-child(1)")
	WebElement newCustomerID;
	
	@FindBy(tagName="h3")
	WebElement customerID;
	
	public AddCustomer() {
		PageFactory.initElements(driver, this);
	}
	
	public void selectPendingRadiobutton() {
		RadioButtonPending.click();
		
	}
	public void selectDoneRadiobutton() {
		RadioButtonDone.click();
		
	}
	
	public void fillDetails(String fname, String lname, String email, String address, String mob) throws InterruptedException {
		TextBoxFirstName.clear();
		TextBoxFirstName.sendKeys(fname);
		TextBoxLastName.clear();
		TextBoxLastName.sendKeys(lname);
		TextBoxEmailId.clear();
		TextBoxEmailId.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", TextBoxEmailId);
		TextBoxEmailId.sendKeys(email);
		TextAreaMessage2.clear();
		TextAreaMessage2.click();
	//	TextAreaMessage2.clear();
	//	TextAreaMessage2.sendKeys(email);
		TextAreaMessage2.sendKeys(address);
		TextBoxMobileNumber.sendKeys(mob);
		
	}
	
	public void clickOnSubmit() {
		SubmitButton.click();
	}
	
	public void closeAds() {
		driver.switchTo().frame("flow_close_btn_iframe");
		ifrmaeCloseButton.click();
		driver.switchTo().defaultContent();
	    
	}
	
	public String getCustomerID() {
		return customerID.getText();
				
	}

}
