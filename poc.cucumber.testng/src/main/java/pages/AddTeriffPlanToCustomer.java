package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class AddTeriffPlanToCustomer extends TestBase {
	
	@FindBy(xpath = "//section[@id='one']//a[contains(@href,'assigntariffplantocustomer.php')]")
	WebElement AddTeriffPlantoCustomerMenuItem;
	
	@FindBy(id = "customer_id")
	WebElement CustomerIDTextbox;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement Submitbutton;
	
	@FindBy(xpath = "//label[@for='sele']")
	WebElement SelectTerifplanRadioButton;
	
	@FindBy(xpath = "//input[@value='Add Tariff Plan to Customer']")
	WebElement AddTeriffPlantoCustomerButton;
	
	@FindBy(xpath = "//tbody[1]/tr[1]/td[1]/b[1]")
	WebElement FirstGridValue;
	
	@FindBy(xpath = "//body[1]/section[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/b[1]")
	WebElement LastGridValue;
	
	@FindBy(xpath = "//h4[contains(text(),'Please Input Your Correct Customer ID')]")
	WebElement ErrorMsgOnIncorrectCustomerID;
	
	@FindBy(xpath = "//a[@href='assigntariffplantocustomer.php'][@class='button']")
	WebElement ButtonAddTeriftocustomeronErrorMsg;
	
	@FindBy(xpath = "//h2[contains(text(),'Congratulation Tariff Plan assigned')]")
	WebElement SuccessMsg;
	
//************************************************************

// initialize page objects
 public AddTeriffPlanToCustomer() {
	PageFactory.initElements(driver, this);
 }
 
 public String verifyAddTeriffPlantoCustomerTitle() {
	return driver.getTitle();
 }
 
 public void clickOnAddTerifPlantoCustomerMenuItem() {
	 AddTeriffPlantoCustomerMenuItem.click();
 }
 
 public void enterCustomerID(String customerid) {
	 CustomerIDTextbox.sendKeys(customerid);
 }
 
 public void clickOnSubmitButton() {
	 Submitbutton.click();
 }
 
 public String errorMessageOnInvalidCustomerID() {
	 return ErrorMsgOnIncorrectCustomerID.getText();
 }
 
 public void clickOnSubmitButtonAfterErrorMsg() {
	 ButtonAddTeriftocustomeronErrorMsg.click();
 }

 public WebElement radiobutton() {
	 return SelectTerifplanRadioButton;
 }
 public void clickOnRadioButton() {
	 SelectTerifplanRadioButton.click();
 }	 
 
 public void clickOnAddTeriffPlantoCustomerButtonAfterRB() {
	 AddTeriffPlantoCustomerButton.click();
 }
	
 public String firstValueInGrid() {
	return FirstGridValue.getText();
 }	
 
 public String lastValueInGrid() {
	 return LastGridValue.getText();
 }
	
public String validateSuccessMsg() {
	return SuccessMsg.getText();
}	
	

}
