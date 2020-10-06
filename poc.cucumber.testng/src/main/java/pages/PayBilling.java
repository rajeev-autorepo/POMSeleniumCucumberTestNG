package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class PayBilling extends TestBase {
	
	@FindBy(xpath = "//div[contains(text(),'')]//div//h3//a[@href='billing.php'][contains(text(),'Pay Billing')]")
	WebElement PayBillinglinkonTelecomPage;
	
	@FindBy(xpath = "//h4[contains(text(),'Please Input Your Correct Customer ID')]")
	WebElement ErrorMsgonIncorrectCustomerID;
	
	@FindBy(xpath = "//a[@class='button']")
	WebElement PayBillingButtonAfterErrorMsg;
	
	@FindBy(xpath = "//b[contains(text(),'Local Minutes')]")
	WebElement LabelLocalMinutes;
	
	@FindBy(xpath = "//b[contains(text(),'International Minutes')]")
	WebElement LabelIntlMinutes;
	
	@FindBy(xpath = "//b[contains(text(),'SMS Pack')]")
	WebElement LabelSMSpack;
	
	@FindBy(xpath = "//tbody/tr[3]/td[2]/b[1]")
	WebElement LabelTeriffPlanAmount;
	
	@FindBy(xpath = "//b[contains(text(),'250')]")
	WebElement LabelUsagesCharges;
	
	@FindBy(xpath = "//b[contains(text(),'750')]")
	WebElement LabelTotalBill;
	
	@FindBy(xpath = "//h1[contains(text(),'Pay Billing')]")
	WebElement HeaderOfPayBilling;
	
	@FindBy(linkText = "Telecom Project")
	WebElement TelecomMenu;
	

//************************************************************

// initialize page objects
 public PayBilling() {
	PageFactory.initElements(driver, this);
 }
 
 public String verifyPayBillingTitle() {
	return driver.getTitle();
 }
	
 public void clickOnPayBillingLink() {
	 PayBillinglinkonTelecomPage.click(); 
 }	
	
 public String errorMessageonIncorrectCustomerID() {
	 return ErrorMsgonIncorrectCustomerID.getText(); 
 }	
	
 public void clickOnPayBillingLinkAfterErrorMsg() {
	 PayBillingButtonAfterErrorMsg.click(); 
 }
 
 public String getLocalMinutesValue() {
	 return LabelLocalMinutes.getText();
 }
 
 public String getIntlMinutesValue() {
	 return LabelIntlMinutes.getText();
 }
 
 public String getSMSpackValue() {
	 return LabelSMSpack.getText();
 }
 
 public String getTeriffplanAmountValue() {
	 return LabelTeriffPlanAmount.getText();
 }
 
 public String getUsageChargesValue() {
	 return LabelUsagesCharges.getText();
 }
 
 public String getTotalBillValue() {
	 return LabelTotalBill.getText();
 }
 
 public String getHeaderValue() {
	 return HeaderOfPayBilling.getText();
 }
 
 public void clickOnTelecomMenu() {
	 TelecomMenu.click();
 }
 
 public boolean visibilityOfHeader() {
	 boolean header= false;
	 if(HeaderOfPayBilling.isDisplayed()) {
		 header = true;
	 }
	 return header;
 }
}
