@AddTeriffPlansToCustomerPage
Feature: Add Teriff Plans feature test 

Scenario: Validate add teriff plans functionality 

	Given user opens up the browser and login
	When click on left three bar icon
	Then user click on Add Teriff Plan to Customer menu item
	Then Enter incorrect customer id and validate error message
	Then enter correct customer id and validate the page title
	Then verify first and last entered value in the grid 
	Then select the radio button and click on add teriff plan to customer button
    Then verify the success message
    Then close the current browser