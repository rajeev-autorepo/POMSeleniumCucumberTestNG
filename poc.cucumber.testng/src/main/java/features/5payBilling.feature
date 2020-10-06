@PayBillingPage
Feature: Pay Billing feature test 

Scenario: Validate Pay Billing functionality 

	Given user launches the browser and login
	When click on Telecom menu and pay billing link
	Then enter incorrect customer id and validate error message
	Then enter correct customer id and validate the page
	Then Verify that Local Minutes, International Minutes and SMS Pack are visible on the page
	Then Verify that Tariff Plan Amout, Usage Charges and Total Bill is displaying
    Then close the chrome browser