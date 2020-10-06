package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class AddTeriffPlans extends TestBase {
	
	@FindBy(id = "rental1")
	WebElement MonthlyRentalTextbox;
	
	@FindBy(id = "local_minutes")
	WebElement FreeLocalMinutesTB;
	
	@FindBy(id = "inter_minutes")
	WebElement FreeInternationalMinutes;
	
	@FindBy(id = "sms_pack")
	WebElement FreeSMSpack;
	
	@FindBy(id = "minutes_charges")
	WebElement LocalPerMinuteCharges;
	
	@FindBy(id = "inter_charges")
	WebElement IntlPerMinuteCharges;
	
	@FindBy(id = "sms_charges")
	WebElement SMSperCharges;
	
	@FindBy(xpath = "//input[@type='reset']")
	WebElement ResetButton;
	
	@FindBy(name = "submit")
	WebElement SubmitButton;
	
	@FindBy(xpath = "//body/span[@id='header']/nav[1]/a[1]")
	WebElement ThreeBars;
	
	@FindBy(xpath = "//a[contains(text(),'Add Tariff Plans')]")
	WebElement AddTeriffPlanMenuItem;
	
	@FindBy(xpath = "//label[@id='message2']")
	WebElement ErrorMsgonMonthlyRental;
	
	@FindBy(xpath = "//label[@id='message3']")
	WebElement ErrorMsgonFreelocalminutes;
	
	@FindBy(xpath = "//h2[contains(text(),'Congratulation you add Tariff Plan')]")
	WebElement SuccessMsgonAddTeriffPlan;
	
//	@FindBy(linkText = "Home")
//	WebElement HomeButtonAfterAddingTeriffPlan;
	
	@FindBy(xpath = "//body/section[@id='main']/div[1]/ul[1]/li[1]/a[1]")
	WebElement HomeButtonAfterAddingTeriffPlan;
	
//************************************************************

// initialize page objects
 public AddTeriffPlans() {
	PageFactory.initElements(driver, this);
 }
 
 public String verifyAddTeriffPlansTitle() {
	return driver.getTitle();
 }
 
 
 public void enterMonthlyRental(String rental) {
	MonthlyRentalTextbox.clear();
	MonthlyRentalTextbox.sendKeys(rental);
 }
 
 public void enterMonthlyRentalvalid(int value) {
	MonthlyRentalTextbox.clear();
	MonthlyRentalTextbox.sendKeys(String.valueOf(value));
 }
 
 public void enterFreeLocalMinutes(String minutes) {
	 FreeLocalMinutesTB.clear();
	 FreeLocalMinutesTB.sendKeys(minutes);
	 }
 
 public void enterFreeInternationalMinutes(String intlminutes) {
	 FreeInternationalMinutes.clear();
	 FreeInternationalMinutes.sendKeys(intlminutes);
	 }
 
 public void enterFreeSMSpack(String sms) {
	 FreeSMSpack.clear();
	 FreeSMSpack.sendKeys(sms);
	 }
 
 public void enterLocalPerMinuteCharges(String localcharge) {
	 LocalPerMinuteCharges.clear();
	 LocalPerMinuteCharges.sendKeys(localcharge);
	 }
 
 public void enterIntlPerMinuteCharges(String intlcharge) {
	 IntlPerMinuteCharges.clear();
	 IntlPerMinuteCharges.sendKeys(intlcharge);
	 }
 
 public void enterSMSperCharges(String smscharge) {
	 SMSperCharges.clear();
	 SMSperCharges.sendKeys(smscharge);
	 }
	
 public void clickOnResetButton() {
	 ResetButton.click();
 }	
 
 public void clickOnSubmitButton() {
	 SubmitButton.click();
 }

 public void clickOnThreeBars() {
	 ThreeBars.click();
 }
	
 public void clickOnAddTeriffPlanMenu() {
	 AddTeriffPlanMenuItem.click();
 }

 public String getErrorMessageOnMonthlyRental() {
	 return ErrorMsgonMonthlyRental.getText();
 }
	
 public String getErrorMessageonFreeLocalMinutes() {
	 return ErrorMsgonFreelocalminutes.getText();
 }
 
 public String getAttributeofMonthlyRental() {
	 return MonthlyRentalTextbox.getAttribute("placeholder");
 }
 
 public String successMsg() {
	 return SuccessMsgonAddTeriffPlan.getText();
 }
 
 public void clickOnHomeButton() {
	 HomeButtonAfterAddingTeriffPlan.click();
 }
}
